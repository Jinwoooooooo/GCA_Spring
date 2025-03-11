package kr.co.ch04.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.ch04.dto.User1DTO;
import kr.co.ch04.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class User1Controller {


    private User1Service service;

    // 생성자 주입
    @Autowired
    public User1Controller(User1Service service) {
        this.service = service;
    }


    @RequestMapping(value = "/user1/list", method = RequestMethod.GET)
    public String list(Model model){

        // 서비스 호출
        List<User1DTO> user1List = service.findAll();

        // 모델 참조 공유
        model.addAttribute("user1List", user1List);

        // 뷰 포워드
        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO dto){
        System.out.println(dto);

        // 서비스 호출
        service.save(dto);

        // 리다이렉트 이동
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(Model model, @RequestParam("uid") String uid){

        // 서비스 호출
        User1DTO dto = service.findById(uid);

        // 모델 참조 공유
        model.addAttribute(dto); // 참조이름을 쓰지 않으면 소문자로 시작하는 객체 타입명

        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO dto){

        // 서비스 호출
        service.update(dto);

        // 리다이렉트
        return "redirect:/user1/list";
    }


}