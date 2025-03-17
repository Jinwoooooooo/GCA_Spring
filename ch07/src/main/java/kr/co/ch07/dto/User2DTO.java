package kr.co.ch07.dto;

import kr.co.ch07.entity.User2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User2DTO {

    private String uid;
    private String pass;
    private String name;
    private String hp;
    private int age;

    //Entity 변환 메서드 정의
    public User2 toEntity() {
        return User2.builder()
                    .uid(uid)
                    .pass(pass)
                    .name(name)
                    .hp(hp)
                    .age(age)
                    .build();
    }
}
