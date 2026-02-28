package com.example.banqueproject.service;

import com.example.banqueproject.dto.ArticlesDto;

import java.util.List;

public interface ArticlesService {
    public List<ArticlesDto> getAllArticlesByCategory(int idCat);
    public List<ArticlesDto> getAllArticles();
}