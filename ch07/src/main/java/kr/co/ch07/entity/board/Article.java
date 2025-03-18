package kr.co.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"comment", "file"})
@Builder
@Entity
@Table(name = "Board_Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT 어노테이션
    private int no;
    private String title;
    private String content;

    // Many: 현재 테이블 / One: 연결할 테이블
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private User user;

    // OneToMany 관계는 List<>
    @OneToMany(mappedBy = "article")
    private List<Comment> comment;

    @OneToMany(mappedBy = "article")
    private List<File> file;

    @CreationTimestamp
    private LocalDateTime wdate;

}
