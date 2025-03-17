package kr.co.ch07.service;

import kr.co.ch07.dto.User2DTO;
import kr.co.ch07.entity.User2;
import kr.co.ch07.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class User2Service {

    private final User2Repository repository;

    public void register(User2DTO dto) {
        User2 user2 = dto.toEntity();
        repository.save(user2);
    }

    public List<User2DTO> findAll() {

        List<User2> Entities = repository.findAll();

        List<User2DTO> user2DTOs = Entities
                                    .stream()
                                    .map(entity -> entity.toDTO())
                                    .toList();
        return user2DTOs;
    }
    public User2DTO findById(String uid) {

        //아이디 조회
        Optional<User2> optUser2 = repository.findById(uid);
        if (optUser2.isPresent()) {
            User2 user2 = optUser2.get();
            return user2.toDTO();
        }

        return null;
    }
    public void modify(User2DTO dto) {
        boolean exist = repository.existsById(dto.getUid());

        if (exist) {
            User2 user2 = dto.toEntity();
            repository.save(user2);
        }
    }
    public void delete(String uid) {
        repository.deleteById(uid);
    }
}
