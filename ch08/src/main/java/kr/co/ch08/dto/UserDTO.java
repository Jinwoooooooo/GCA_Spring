package kr.co.ch08.dto;

import kr.co.ch08.entity.User; // 엔티티 ↔ DTO 변환 시 사용
import lombok.*;

@Data               // Getter, Setter, toString, equals, hashCode 다 포함
@AllArgsConstructor // 전체 필드 초기화하는 생성자 자동 생성
@NoArgsConstructor  // 기본 생성자 자동 생성
@ToString           // toString 자동 생성
@Builder            // 빌더 패턴 지원
public class UserDTO {

    private String uid;   // 사용자 ID
    private String pass;  // 비밀번호
    private String name;  // 이름
    private String birth; // 생년월일
    private String role;  // 권한 (예: USER, ADMIN)

    // DTO를 Entity로 변환하는 메서드
    public User toEntity() {
        return User.builder()
                .uid(uid)
                .pass(pass)
                .name(name)
                .birth(birth)
                .role(role)
                .build();
    }
}
