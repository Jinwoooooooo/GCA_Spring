package kr.co.ch07.service;

import kr.co.ch07.dto.User1DTO;
import kr.co.ch07.entity.User1;
import kr.co.ch07.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class User1Service {

    // @RequiredArgsConstructor 어노테이션으로 생성자 주입
    private final User1Repository repository;

    public void register(User1DTO dto) {
        log.info("dto" + dto);

        // DTO를 Entity로 변환
        User1 user1 = dto.toEntity();
        log.info("user1" + user1);

        // Entity 저장(Insert 실행)
        repository.save(user1);
    }

    public List<User1DTO> findAll() {

        // Entity 전체 조회
        List<User1> Entities = repository.findAll();

        // DTO 리스트 변환
        List<User1DTO> dtos = new ArrayList<>();

        /*
        외부 반복자를 이용하기 때문에 성능에서 불리
        for(User1 user1 : Entities) {
            dtos.add(user1.toDTO());
        }
        */
        // 내부 반복자를 이용한 변환
        List<User1DTO> user1DTOS = Entities
                                    .stream()
                                    .map(entity-> entity.toDTO())
                                    .toList();

        return user1DTOS;
    }

    public User1DTO findById(String uid) {

        // 아이디 조회
        Optional<User1> optUser1 = repository.findById(uid);

        // 옵셔널 엔티티 검사
        if(optUser1.isPresent()) {

            User1 user1 = optUser1.get();
            return user1.toDTO();
        }

        return null;
    }

    public void modify(User1DTO dto) {

        boolean exist = repository.existsById(dto.getUid());

        // 수정할 Entity가 존재하면
        if(exist) {
            User1 user1 = dto.toEntity();

            //Entity 수정(save는 Entity가 존재하지 않으면 insert, 존재하면 update)
            repository.save(user1);
        }
    }

    public void delete(String uid) {
        repository.deleteById(uid);
    }
}
