package com.wechap.wechap.service;

import com.wechap.wechap.dao.UserDAO;
import com.wechap.wechap.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO ud;

    public void signUp(UserDTO userDto) {
        ud.signUp(userDto);
    }
}
