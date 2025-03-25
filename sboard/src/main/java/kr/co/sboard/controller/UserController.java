package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.co.sboard.config.AppInfo;
import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.service.TermsService;
import kr.co.sboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final TermsService termsService;
    private final UserService userService;

    @GetMapping("/user/info")
    public String info(){
        return "/user/info";
    }

    @GetMapping("/user/login")
    public String login(){




        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register(){
        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(HttpServletRequest req, UserDTO userDTO){

        String regip = req.getRemoteAddr();
        userDTO.setRegip(regip);

        // 서비스 호출
        userService.register(userDTO);

        // 리다이렉트
        return "redirect:/user/login";
    }

    @GetMapping("/user/terms")
    public String terms(Model model){

        TermsDTO termsDTO = termsService.terms();
        model.addAttribute(termsDTO);

        return "/user/terms";
    }


    @GetMapping("/user/{type}/{value}")
    public ResponseEntity user(@PathVariable("type") String type, @PathVariable("value") String value){
        log.info("type : " + type + ", value : " + value);

        // 서비스 호출
        long count = userService.checkUser(type, value);

        // JSON 생성
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("count", count);

        // JSON 반환
        return ResponseEntity.ok().body(resultMap);
    }

    @PostMapping("/user/email/auth")
    public ResponseEntity<Boolean> emailAuth(@RequestBody Map<String, String> map, HttpSession session) { // JSON 단일 문자열값이 직접 String으로 매핑되지 않기 떄문에 JSON과 호환되는 Map 타입으로 JSON 수신
        log.info("authCode : {}", map.get("authCode"));

        String authCode = map.get("authCode");
        String sessAuthCode = (String) session.getAttribute("authCode");

        if(sessAuthCode.equals(authCode)) {
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
}
