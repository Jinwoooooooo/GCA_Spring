package kr.co.ch05.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.ch05.dto.User1DTO;
import kr.co.ch05.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class User1Controller {

    private final User1Service user1Service;

    @Autowired
    public User1Controller(User1Service user1Service) {
        this.user1Service = user1Service;
    }

    @RequestMapping(value = "/user1/list", method = RequestMethod.GET)
    public String list(Model model) {

        //데이터 조회
        List<User1DTO> dtos = user1Service.findAll();
        
        //모델 참조
        model.addAttribute("dtos", dtos);
        
        //뷰 포워딩
        return "list"; //WEB-INF에 뷰
    }

    @GetMapping("/user1/register")
    public String register() {
        return "register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO dto) {

        //서비스 호출
        user1Service.register(dto);

        //리다이렉트
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(@RequestParam("uid") String uid, Model model) {

        //수정 데이터 조회
        User1DTO user = user1Service.findById(uid);

        //수정 출력하기 위해 모델 참조
        model.addAttribute("user", user);

        return "modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO dto) {
        user1Service.modify(dto);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(@RequestParam("uid") String uid) {
        user1Service.delete(uid);
        return "redirect:/user1/list";
    }
}
