package kr.co.ch09.dto;

import jakarta.validation.constraints.*;
import kr.co.ch09.entity.User2;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User2DTO {

    @NotBlank // null, "", " " 허용 안 함
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "영어 소문자, 숫자로 최소 4 ~ 10 입력")
    private String uid;

    @NotNull
    private String pass;

    @NotEmpty // null, "" 허용 안 함
    @Pattern(regexp = "^[가-힣]{2,10}$", message = "한글 이름 2 ~ 10 입력")
    private String name;

    @NotNull
    private String hp;

    @Min(1) @Max(100)
    private int age;

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
