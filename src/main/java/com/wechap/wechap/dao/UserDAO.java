package com.wechap.wechap.dao;

import com.wechap.wechap.dto.UserDTO;
import com.wechap.wechap.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    @Autowired
    private UserMapper um;

    public void signUp(UserDTO userDto) {
        um.signUp(userDto);
    }
}
