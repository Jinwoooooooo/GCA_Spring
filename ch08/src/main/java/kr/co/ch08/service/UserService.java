package kr.co.ch08.service;

import kr.co.ch08.dto.UserDTO;
import kr.co.ch08.entity.User;
import kr.co.ch08.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(UserDTO userDTO){
        // 시큐리티 인코더로 비밀번호 암호화
        String encodedPass = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encodedPass);

        // DTO를 Entity로 변환
        User user = userDTO.toEntity();

        // 사용자 저장
        userRepository.save(user);
    }
}
