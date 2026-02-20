package com.example.banqueproject.dto.mapper;

import com.example.banqueproject.dto.ClientDto;
import com.example.banqueproject.entity.Clients;

public class ClientMapper {

    public static ClientDto clientToCLientDto(Clients client){
        return new ClientDto(
                client.getId(),
                client.getEmail(),
                client.getNom(),
                client.getAdresse(),
                client.getCodePostal(),
                client.getVille(),
                client.getTel());
    }
}
