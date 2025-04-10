package kr.co.ch08.security;

import kr.co.ch08.entity.User;
import kr.co.ch08.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j // 로그 출력용 애너테이션 (log.info 등 사용 가능)
@RequiredArgsConstructor // final 필드를 자동으로 생성자 주입해줌
@Service // Spring에서 이 클래스를 서비스 컴포넌트로 등록
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository; // 사용자 정보를 가져오기 위한 JPA 리포지토리

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Spring Security에서 로그인 시 이 메서드가 자동으로 호출됨
        // username: 로그인 폼에서 입력한 아이디가 전달됨

        log.info("username : {}", username); // 입력된 아이디 로그 출력

        // DB에서 아이디로 사용자 정보 조회
        Optional<User> optUser = userRepository.findById(username);

        if(optUser.isPresent()) {
            // 사용자가 존재하면, User 엔티티를 MyUserDetails에 감싸서 반환
            MyUserDetails myUserDetails = MyUserDetails.builder()
                    .user(optUser.get()) // User 객체 전달
                    .build();

            // 이 객체는 Spring Security 내부에서 인증된 사용자 정보로 사용됨
            return myUserDetails;
        }

        // 사용자가 없을 경우 예외를 던지는 게 보통의 방식이지만,
        // 여기선 null 반환 → 실제론 UsernameNotFoundException을 던지는 게 더 안전함
        return null;
    }
}
