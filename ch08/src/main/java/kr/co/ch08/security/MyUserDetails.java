package kr.co.ch08.security;

import kr.co.ch08.entity.User; // 실제 사용자 정보를 담는 도메인 객체
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data // Getter, Setter, toString, equals, hashCode 자동 생성
@Builder // 빌더 패턴 지원
public class MyUserDetails implements UserDetails { // UserDetails를 구현해서 커스텀 사용자 정보를 Spring Security에 맞게 제공

    private User user; // 실제 사용자 정보를 담은 객체 (DB에서 조회된 사용자 정보)

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 사용자에게 부여된 권한(역할)을 반환함
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Spring Security는 권한 이름 앞에 "ROLE_"을 붙여야 함 (예: ROLE_ADMIN, ROLE_USER)
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

        return authorities;
    }

    @Override
    public String getPassword() {
        // 사용자의 비밀번호 반환 (인증 시 사용)
        return user.getPass();
    }

    @Override
    public String getUsername() {
        // 사용자의 고유 아이디 반환 (로그인 시 입력한 아이디와 비교됨)
        return user.getUid();
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부 확인 (true면 만료되지 않음)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠김 여부 확인 (true면 잠기지 않음)
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 비밀번호 만료 여부 확인 (true면 유효함)
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 계정 활성화 여부 확인 (true면 활성 상태)
        return true;
    }
}
