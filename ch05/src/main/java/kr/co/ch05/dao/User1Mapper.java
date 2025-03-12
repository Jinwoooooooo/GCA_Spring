package kr.co.ch05.dao;

import kr.co.ch05.dto.User1DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User1Mapper {

    public void insertUser1(User1DTO dto);
    public User1DTO selectUser1(String uid);
    public List<User1DTO> selectAllUser1();
    public void updateUser1(User1DTO dto);
    public void deleteUser1(String uid);

}
