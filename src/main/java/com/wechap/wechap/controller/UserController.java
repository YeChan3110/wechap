package com.wechap.wechap.controller;

import com.wechap.wechap.dto.UserDTO;
import com.wechap.wechap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService us;

    // ExceptionHandler
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        e.printStackTrace();
        return "/error";
    }

    @RequestMapping("toLogin") // 로그인 페이지로 이동
    public String toLogin() {
        return "user/login";
    }

    @RequestMapping("toSignUp") // 회원가입 페이지로 이동
    public String toSignUp() {
        return "user/signUp";
    }

    @PostMapping("signUp") // 회원가입
    public String signUp(UserDTO userDto) {
        us.signUp(userDto);
        return "redirect:/";
    }

}
