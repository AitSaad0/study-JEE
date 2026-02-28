package com.example.banqueproject.dto.mapper;

import com.example.banqueproject.dto.ArticlesDto;
import com.example.banqueproject.entity.Articles;

public class ArticlesMapper {

    public static ArticlesDto toDTO(Articles article) {
        if (article == null) return null;

        ArticlesDto dto = new ArticlesDto();
        dto.setCodeArticle(article.getCodeArticle());
        dto.setReference(article.getReference());
        dto.setPrix(article.getPrix());
        dto.setStock(article.getStock());
        dto.setCategorie(article.getCategorie());
        dto.setPhoto(article.getPhoto());
        dto.setTitle(article.getTitle());
        dto.setAuthor(article.getAuthor());

        return dto;
    }


    public static Articles toEntity(ArticlesDto dto) {
        if (dto == null) return null;

        Articles article = new Articles();
        article.setCodeArticle(dto.getCodeArticle());
        article.setReference(dto.getReference());
        article.setPrix(dto.getPrix());
        article.setStock(dto.getStock());
        article.setCategorie(dto.getCategorie());
        article.setPhoto(dto.getPhoto());
        article.setTitle(dto.getTitle());
        article.setAuthor(dto.getAuthor());

        return article;
    }
}
