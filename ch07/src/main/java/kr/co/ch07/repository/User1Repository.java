package kr.co.ch07.repository;

import kr.co.ch07.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository //레파지토리는 인터페이스
public interface User1Repository extends JpaRepository<User1, String> {

    //쿼리 메서드 실습
    public User1 findUser1ByUid(String uid);
    public List<User1> findUser1ByName(String name);
    public List<User1> findUser1ByNameNot(String name);

    public User1 findUser1ByUidAndName(String uid, String name);
    public List<User1> findUser1ByUidOrName(String uid, String name);
    public List<User1> findUser1ByAgeGreaterThan(int age);
    public List<User1> findUser1ByAgeGreaterThanEqual(int age);
    public List<User1> findUser1ByAgeLessThan(int age);
    public List<User1> findUser1ByAgeLessThanEqual(int age);
    public List<User1> findUser1ByAgeBetween(int low, int high);

    public List<User1> findUser1ByNameLike(String name);
    public List<User1> findUser1ByNameContains(String name);
    public List<User1> findUser1ByNameStartsWith(String name);
    public List<User1> findUser1ByNameEndsWith(String name);

    public List<User1> findUser1ByOrderByName();
    public List<User1> findUser1ByNameOrderByUid(String name);
    public List<User1> findUser1ByOrderByAgeAsc();
    public List<User1> findUser1ByOrderByAgeDesc();
    public List<User1> findUser1ByAgeGreaterThanOrderByAgeDesc(int age);

    public int countUser1ByName(String name);

    // JPQL
    @Query("SELECT u1 FROM User1 AS u1 WHERE u1.age <= 30")
    public List<User1> selectUser1UnderAge30();

    @Query("SELECT u1 FROM User1 AS u1 WHERE u1.name = ?1")
    public List<User1> selectUser1ByName(String name);

    @Query("SELECT u1 FROM User1 AS u1 WHERE u1.name = :name")
    public List<User1> selectUser1ByNameParam(@Param("name") String name);

    @Query("SELECT u1.uid, u1.name, u1.age FROM User1 AS u1 WHERE u1.uid = :uid")
    public List<Object[]> selectUser1ByUid(@Param("uid") String uid);

    @Query("SELECT p, c FROM Parent AS p " +
                        "JOIN Child AS c " +
                        "ON p.pid = c.parent " +
                        "WHERE p.pid = :pid")
    public List<Object[]> selectAllParentWithChild(@Param("pid") String pid);


}
