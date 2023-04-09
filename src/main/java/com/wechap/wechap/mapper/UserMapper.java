package com.wechap.wechap.mapper;

import com.wechap.wechap.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void signUp(UserDTO userDto);
}
