package kr.co.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch08.dto.UserDTO;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "User")
public class User {

    @Id
    private String uid;
    private String pass;
    private String name;
    private String birth;
    private String role;

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
