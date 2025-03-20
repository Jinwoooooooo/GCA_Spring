package kr.co.ch09.service;

import kr.co.ch09.dto.User2DTO;
import kr.co.ch09.entity.User1;
import kr.co.ch09.entity.User2;
import kr.co.ch09.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class User2Service {

    private final User2Repository user2Repository;

    public User2DTO save(User2DTO user2DTO) {
        User2 user = user2DTO.toEntity();
        User2 savedUser2 = user2Repository.save(user);
        return savedUser2.toDTO();
    }

    public User2DTO findById(String uid) {
        Optional<User2> optUser2 = user2Repository.findById(uid);

        if(optUser2.isPresent()) {
            return optUser2.get().toDTO();
        }
        return null;
    }

    public List<User2DTO> findAll() {
        List<User2> list = user2Repository.findAll();
        return list.stream().map(entity -> entity.toDTO()).toList();
    }

    public User2DTO modify(User2DTO user2DTO) {

        if(user2Repository.existsById(user2DTO.getUid())) {
            User2 user = user2DTO.toEntity();
            User2 savedUser2 = user2Repository.save(user);
            return savedUser2.toDTO();
        }
        return null;
    }

    public boolean delete(String uid) {

        if(user2Repository.existsById(uid)) {
            user2Repository.deleteById(uid);
            return true;
        }
        return false;
    }
}
