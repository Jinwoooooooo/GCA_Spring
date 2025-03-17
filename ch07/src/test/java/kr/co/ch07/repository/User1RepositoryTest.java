package kr.co.ch07.repository;

import kr.co.ch07.entity.Child;
import kr.co.ch07.entity.Parent;
import kr.co.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository repository;
    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUid() {
        //given
        String uid = "test";

        //when
        User1 user1 = user1Repository.findUser1ByUid(uid);

        //then
        System.out.println(user1);
    }

    @Test
    void findUser1ByName() {
        //given
        String name = "name";

        //when
        List<User1> user1 = user1Repository.findUser1ByName(name);

        //then
        System.out.println(user1);
    }

    @Test
    void findUser1ByNameNot() {
        //given
        String name = "name";

        //when
        List<User1> user1 = user1Repository.findUser1ByNameNot(name);

        //then
        System.out.println(user1);
    }

    @Test
    void findUser1ByUidAndName() {
        String uid = "test";
        String name = "name";

        User1 user1 = user1Repository.findUser1ByUidAndName(uid, name);

        System.out.println(user1);
    }

    @Test
    void findUser1ByUidOrName() {
        String uid = "test";
        String name = "팜하니";

        List<User1> user1 = user1Repository.findUser1ByUidOrName(uid, name);

        System.out.println(user1);
    }

    @Test
    void findUser1ByAgeGreaterThan() {
        int age = 20;

        List<User1> user1 = user1Repository.findUser1ByAgeGreaterThan(age);

        System.out.println(user1);
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
        int age = 20;

        List<User1> user1 = user1Repository.findUser1ByAgeGreaterThanEqual(age);

        System.out.println(user1);
    }

    @Test
    void findUser1ByAgeLessThan() {
        int age = 29;

        List<User1> user1 = user1Repository.findUser1ByAgeLessThan(age);

        System.out.println(user1);
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
        int age = 29;

        List<User1> user1 = user1Repository.findUser1ByAgeLessThanEqual(age);

        System.out.println(user1);
    }

    @Test
    void findUser1ByAgeBetween() {
        int low = 20;
        int high = 25;

        List<User1> user1 = user1Repository.findUser1ByAgeBetween(low, high);

        System.out.println(user1);
    }

    @Test
    void findUser1ByNameLike() {
        String name = "name";

        List<User1> user1 = user1Repository.findUser1ByNameLike(name);

        System.out.println(user1);
    }

    @Test
    void findUser1ByNameContains() {
        String name = "name";

        List<User1> user1 = user1Repository.findUser1ByNameContains(name);

        System.out.println(user1);
    }

    @Test
    void findUser1ByNameStartsWith() {
        String name = "n";

        List<User1> user1 = user1Repository.findUser1ByNameStartsWith(name);

        System.out.println(user1);
    }

    @Test
    void findUser1ByNameEndsWith() {
        String name = "니";

        List<User1> user1 = user1Repository.findUser1ByNameEndsWith(name);

        System.out.println(user1);
    }

    @Test
    void findUser1ByOrderByName() {
        List<User1> user1 = user1Repository.findUser1ByOrderByName();

        System.out.println(user1);
    }

    @Test
    void findUser1ByNameOrderByUid() {
        String name = "name";

        List<User1> user1 = user1Repository.findUser1ByNameOrderByUid(name);

        System.out.println(user1);
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
        List<User1> user1 = user1Repository.findUser1ByOrderByAgeAsc();

        System.out.println(user1);
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
        List<User1> user1 = user1Repository.findUser1ByOrderByAgeDesc();

        System.out.println(user1);
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
        int age = 25;

        List<User1> user1 = user1Repository.findUser1ByAgeGreaterThanOrderByAgeDesc(age);

        System.out.println(user1);
    }

    @Test
    void countUser1ByName() {
        String name = "name";

        int user1 = user1Repository.countUser1ByName(name);

        System.out.println(user1);
    }

    @Test
    void selectUser1UnderAge30() {
        List<User1> user1 = user1Repository.selectUser1UnderAge30();
        System.out.println(user1);
    }

    @Test
    void selectUser1ByName() {
        String name = "팜하니";
        List<User1> user1 = user1Repository.selectUser1ByName(name);
        System.out.println(user1);
    }

    @Test
    void selectUser1ByNameParam() {
        String name = "팜하니";
        List<User1> user1 = user1Repository.selectUser1ByNameParam(name);
        System.out.println(user1);
    }

    @Test
    void selectUser1ByUid() {
        String selectId = "pham22";
        List<Object[]> user1List = user1Repository.selectUser1ByUid(selectId);

        for (Object[] o : user1List) {
            String uid = (String) o[0];
            String name = (String) o[1];
            Integer age = (Integer) o[2];

            System.out.println("UID: " + uid + ", Name: " + name + ", Age: " + age);
        }
    }

    @Test
    void selectAllParentWithChild() {
        //given
        String pid = "p101";

        //when
        List<Object[]> list = user1Repository.selectAllParentWithChild(pid);

        //then
        for (Object[] o : list) {
            Parent parent = (Parent) o[0];
            Child child = (Child) o[1];

            System.out.println(parent);
            System.out.println(child);
        }
    }
}