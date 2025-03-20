package kr.co.ch09.service;

import kr.co.ch09.dto.User1DTO;
import kr.co.ch09.entity.User1;
import kr.co.ch09.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class User1Service {

    private final User1Repository user1Repository;

    public User1DTO save(User1DTO user1DTO) {
        User1 user = user1DTO.toEntity();
        User1 savedUser1 = user1Repository.save(user);

        return savedUser1.toDTO();
    }

    public List<User1DTO> findAll() {
        List<User1> list = user1Repository.findAll();

        return list.stream().map(entity -> entity.toDTO()).toList();
    }

    public User1DTO findById(String uid) {
        Optional<User1> optUser1 = user1Repository.findById(uid);

        if (optUser1.isPresent()) {
            return optUser1.get().toDTO();
        }

        return null;
    }

    public User1DTO modify(User1DTO user1DTO) {

        if (user1Repository.existsById(user1DTO.getUid())) {
            User1 user1 = user1DTO.toEntity();
            User1 savedUser1 = user1Repository.save(user1);
            return savedUser1.toDTO();
        }
        return null;
    }

    public boolean delete(String uid) {

        if(user1Repository.existsById(uid)) {
            user1Repository.deleteById(uid);
            return true;
        }
        return false;
    }
}
