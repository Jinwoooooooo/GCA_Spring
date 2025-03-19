package kr.co.ch08.dto;

import kr.co.ch08.entity.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {
    private String uid;
    private String pass;
    private String name;
    private String birth;
    private String role;

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
