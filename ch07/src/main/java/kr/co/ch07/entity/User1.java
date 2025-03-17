package kr.co.ch07.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.dto.User1DTO;
import lombok.*;

// 엔티티는 @Setter는 안 씀
@Table(name = "user1")  //매핑 테이블 어노테이션
@Entity                 //엔티티 정의 어노테이션
@Getter
@Builder // 객체 생성할 때 빌더 방식으로 생성하기 위해 선언하는 어노테이션
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User1 {

    @Id                    // PK 컬럼 설정 어노테이션(생략 불가)
    private String uid;

    @Column(name = "name") //매핑 컬럼 설정 어노테이션(필드속성명과 컬럼명이 동일할 경우 생략 가능)
    private String name;

    @Column(name = "hp")
    private String hp;

    private int age;

    // DTO 변환 메서드 정의
    public User1DTO toDTO() {
        return User1DTO.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }
}
