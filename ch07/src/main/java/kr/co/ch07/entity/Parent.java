package kr.co.ch07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Parent")
public class Parent {

    @Id
    private String pid;
    private String name;
    private String birth;
    private String addr;
}
