package kr.co.ch07.repository;

import kr.co.ch07.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository //레파지토리는 인터페이스
public interface User1Repository extends JpaRepository<User1, String> {

}
