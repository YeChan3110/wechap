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

    // ExceptionHandler
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        e.printStackTrace();
        return "/error";
    }

    @Autowired
    private UserService us;

    @RequestMapping("toSignUp")
    public String toSignUp() throws Exception{
        return "user/signUp";
    }

    @PostMapping("signUp")
    public String signUp(UserDTO userDto) throws Exception{
        us.signUp(userDto);
        return "redirect:/";
    }

}
