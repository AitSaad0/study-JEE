package com.example.banqueproject.dto;

public record PrintedArticleDto(
        String reference,
        String titre,
        String auteur,
        String photo,
        Double prix
) {
}
