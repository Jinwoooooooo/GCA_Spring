package kr.co.ch06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Sub1Controller {

    @GetMapping("/sub1/hello")
    public String hello(){
        return "/sub1/hello";
    }

    @GetMapping("/sub1/welcome")
    public String welcome(){
        return "/sub1/welcome";
    }

    @GetMapping("/sub1/greeting")
    public String greeting(){
        return "/sub1/greeting";
    }

}
