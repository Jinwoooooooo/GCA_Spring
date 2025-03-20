package kr.co.ch09.controller;

import jakarta.validation.Valid;
import kr.co.ch09.dto.User2DTO;
import kr.co.ch09.repository.User2Repository;
import kr.co.ch09.service.User2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST API 서비스 컨트롤러 어노테이션
@RestController
@Slf4j
@RequiredArgsConstructor
public class User2Controller {

    private final User2Service user2Service;

    @ResponseBody
    @GetMapping("/user2")
    public List<User2DTO> list() {
        return user2Service.findAll();
    }

    @ResponseBody
    @GetMapping("/user2/{uid}")
    public User2DTO user(@PathVariable("uid") String uid) {
        return user2Service.findById(uid);
    }

    @PostMapping("/user2")
    public ResponseEntity<User2DTO> register(@Valid @RequestBody User2DTO user2DTO) {

        User2DTO savedUser2 = user2Service.save(user2DTO);
        return ResponseEntity.ok(savedUser2);
    }

    @PutMapping("/user2")
    public ResponseEntity<User2DTO> modify(User2DTO user2DTO) {
        User2DTO modifiedUser2 = user2Service.modify(user2DTO);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser2);
    }

    @DeleteMapping("/user2/{uid}")
    public ResponseEntity<String> delete(@PathVariable("uid") String uid) {
        boolean isDeleted = user2Service.delete(uid);

        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("success");
        }
        return ResponseEntity.notFound().build();
    }
}
