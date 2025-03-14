package kr.co.ch06.service;

import kr.co.ch06.dto.User1DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class User1ServiceTest {

    @Autowired
    private User1Service user1Service;

    @Test
    void register() {

        //given
        User1DTO givenUser = User1DTO.builder()
                .uid("test3")
                .name("name1")
                .hp("010-1111-1111")
                .age(20)
                .build();

        //when
        user1Service.register(givenUser);

        //then
        User1DTO expected = user1Service.findById(givenUser.getUid());
        Assertions.assertNotNull(expected);

        System.out.println(expected);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void modify() {
    }

    @Test
    void deleteUser1() {
    }
}