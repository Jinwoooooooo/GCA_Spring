package kr.co.ch04.dao;

import kr.co.ch04.dto.User1DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User1DAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void insertUser1(User1DTO dto){

        String sql = "insert into user1 values(?,?,?,?)";

        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getHp(),
                dto.getAge()
        };

        jdbcTemplate.update(sql, params);
    }

    public User1DTO selectUser1(String uid){
        String sql = "select * from user1 where uid=?";
        Object[] params = {uid};

        return jdbcTemplate.queryForObject(sql, new User1RowMapper(), params);
    }

    public List<User1DTO> selectAllUser1(){
        String sql = "select * from user1";
        return jdbcTemplate.query(sql, new User1RowMapper());
    }

    public void updateUser1(User1DTO dto){

        String sql = "update user1 set name=?,hp=?,age=? where uid=?";
        Object[] params = {
                dto.getName(),
                dto.getHp(),
                dto.getAge(),
                dto.getUid()
        };
        jdbcTemplate.update(sql, params);
    }

    public void deleteUser1(String uid){

    }


}