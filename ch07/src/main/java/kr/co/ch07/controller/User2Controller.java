package kr.co.ch07.controller;

import kr.co.ch07.dto.User2DTO;
import kr.co.ch07.service.User2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class User2Controller {

    private final User2Service service;

    @GetMapping("/user2/list")
    public String list(Model model) {
        List<User2DTO> user2DTOList = service.findAll();
        model.addAttribute("user2DTOList", user2DTOList);
        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register() {
        return "/user2/register";
    }
    @PostMapping("/user2/register")
    public String register(User2DTO dto) {
        service.register(dto);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(String uid, Model model) {
        User2DTO dto = service.findById(uid);
        model.addAttribute("user2DTO", dto);
        return "/user2/modify";
    }
    @PostMapping("/user2/modify")
    public String modify(User2DTO dto) {
        service.modify(dto);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(String uid) {
        service.delete(uid);
        return "redirect:/user2/list";
    }
}
