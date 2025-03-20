package kr.co.ch09.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch09.dto.User2DTO;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user2")
public class User2 {

    @Id
    private String uid;
    private String pass;
    private String name;
    private String hp;
    private int age;

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
