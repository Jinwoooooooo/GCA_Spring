package kr.co.ch06.controller;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.service.User1Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class User1Controller {

    private final User1Service user1Service;
    //---------- List ----------
    @GetMapping("/user1/list")
    public String list(Model model){
        List<User1DTO> user1List = user1Service.findAll();
        model.addAttribute("user1List", user1List);
        return "/user1/list";
    }

    //---------- Register ----------
    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }
    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO) {
        log.info("user1DTO: {}", user1DTO);
        user1Service.register(user1DTO);
        return "redirect:/user1/list";
    }

    //---------- Modify ----------
    @GetMapping("/user1/modify")
    public String modify(String uid, Model model) { //스프링부트는 @RequestParam("uid") 안해도 됨
        log.info("uid: {}", uid);
        User1DTO user1DTO = user1Service.findById(uid);
        model.addAttribute("user1DTO", user1DTO);
        return "/user1/modify";
    }
    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO) {
        log.info("user1DTO: {}", user1DTO);
        user1Service.modify(user1DTO);
        return "redirect:/user1/list";
    }

    //---------- Delete ----------
    @GetMapping("/user1/delete")
    public String delete(String uid) {
        log.info("uid: {}", uid);
        user1Service.deleteUser1(uid);
        return "redirect:/user1/list";
    }
}
