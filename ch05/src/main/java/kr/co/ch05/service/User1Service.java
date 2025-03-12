package kr.co.ch05.service;

import kr.co.ch05.dao.User1Mapper;
import kr.co.ch05.dto.User1DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User1Service {

    private final User1Mapper user1Mapper;

    @Autowired
    public User1Service(User1Mapper user1Mapper) {
        this.user1Mapper = user1Mapper;
    }

    public void register(User1DTO dto) {
        user1Mapper.insertUser1(dto);
    }

    public List<User1DTO> findAll() {
        return user1Mapper.selectAllUser1();
    }

    public User1DTO findById(String uid) {
        return user1Mapper.selectUser1(uid);
    }

    public void modify(User1DTO dto) {
        user1Mapper.updateUser1(dto);
    }

    public void delete(String uid) {
        user1Mapper.deleteUser1(uid);
    }
}
