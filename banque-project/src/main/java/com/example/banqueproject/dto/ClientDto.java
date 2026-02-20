package com.example.banqueproject.dto;

public record ClientDto(
        int id,
        String email,
        String nom,
        String adresse,
        String codePostal,
        String ville,
        String tel
) {
}
