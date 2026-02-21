package com.example.banqueproject.dto.mapper;

import com.example.banqueproject.dto.ArticlesDto;
import com.example.banqueproject.dto.PrintedArticleDto;

public class PrintedArticleMapper {

    public static PrintedArticleDto fromDto(ArticlesDto dto) {
        if (dto == null) return null;

        return new PrintedArticleDto(
                dto.getDesignation(),
                dto.getTitre(),
                dto.getAuteur(),
                dto.getPhoto(),
                dto.getPrix()
        );
    }
}
