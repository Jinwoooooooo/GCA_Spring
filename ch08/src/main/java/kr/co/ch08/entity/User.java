package kr.co.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch08.dto.UserDTO;
import lombok.*;

@Getter               // 모든 필드에 대한 getter 자동 생성
@AllArgsConstructor   // 모든 필드를 인자로 받는 생성자 생성
@NoArgsConstructor    // 파라미터 없는 기본 생성자 생성
@ToString             // toString 자동 생성
@Builder              // 빌더 패턴 지원
@Entity               // JPA 엔티티 클래스임을 나타냄 (DB 테이블과 매핑됨)
@Table(name = "User") // 매핑될 테이블 이름 지정 (User 테이블)
public class User {

    @Id // 기본 키 지정 (uid는 Primary Key)
    private String uid;

    private String pass;  // 사용자 비밀번호
    private String name;  // 사용자 이름
    private String birth; // 생년월일 (문자열 형식)
    private String role;  // 사용자 권한 (예: USER, ADMIN)

    // 이 엔티티 객체를 DTO로 변환하는 메서드
    public UserDTO toDTO() {
        return UserDTO.builder()
                .uid(uid)
                .pass(pass)
                .name(name)
                .birth(birth)
                .role(role)
                .build();
    }
}
