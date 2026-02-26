package com.example.banqueproject.dto.mapper;

import com.example.banqueproject.dto.UserDto;
import com.example.banqueproject.entity.Users;

public class UserMapper {

    public static UserDto clientToCLientDto(Users user){
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getAddress(),
                user.getZip(),
                user.getCity(),
                user.getTel());
    }
}
