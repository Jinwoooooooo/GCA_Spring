package kr.co.ch07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.dto.User2DTO;
import lombok.*;

@Table(name = "user2")
@Entity
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User2 {

    @Id
    private String uid;
    private String pass;
    private String name;
    private String hp;
    private int age;

    // DTO 변환 메서드 정의
    public User2DTO toDTO() {
        return User2DTO.builder()
                        .uid(uid)
                        .pass(pass)
                        .name(name)
                        .hp(hp)
                        .age(age)
                        .build();
    }
}
