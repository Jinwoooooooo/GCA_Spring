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
@Table(name = "Child")
public class Child {

    @Id
    private String cid;
    private String name;
    private String hp;
    private String parent;

}
