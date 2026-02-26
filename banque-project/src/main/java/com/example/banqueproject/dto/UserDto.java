package com.example.banqueproject.dto;

public record UserDto(
        int id,
        String email,
        String name,
        String address,
        String zip,
        String city,
        String tel
) {
}
