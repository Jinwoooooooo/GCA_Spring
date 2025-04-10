package kr.co.ch08.controller;

import kr.co.ch08.dto.UserDTO;
import kr.co.ch08.entity.User;
import kr.co.ch08.repository.UserRepository;
import kr.co.ch08.security.MyUserDetails;
import kr.co.ch08.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService service;

    @GetMapping("/user/login")
    public String login(){
        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register(){
        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(UserDTO userDTO){

        log.info("userDTO : {} ", userDTO);

        service.register(userDTO);
        return "redirect:/user/login";
    }

    @GetMapping("/user/info") // 클라이언트가 "/user/info" 경로로 GET 요청을 보냈을 때 실행됨
    public String info(Model model) {

        // 현재 인증된 사용자의 인증 정보를 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("authentication : {}", authentication); // 인증 객체 정보 로그 출력

        // 인증 객체에서 사용자 정보를 꺼냄 (직접 만든 UserDetails 구현체로 캐스팅)
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();

        // MyUserDetails에서 실제 User 도메인 객체를 꺼냄
        User user = myUserDetails.getUser();
        log.info("user : {}", user); // 사용자 정보 로그 출력

        // 모델에 사용자 정보를 추가하여 뷰에서 사용할 수 있게 함
        model.addAttribute(user); // 이름 없이 넣으면 객체의 클래스 이름이 키로 사용됨 (즉, "user")

        // 사용자 정보를 보여주는 뷰 페이지로 이동 (/templates/user/info.html)
        return "/user/info";
    }




}
