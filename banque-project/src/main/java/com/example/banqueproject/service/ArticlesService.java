package com.example.banqueproject.service;

import com.example.banqueproject.dto.PrintedArticleDto;

import java.util.List;

public interface ArticlesService {
    public List<PrintedArticleDto> getAllArticlesByCategory(int idCat);
    public List<PrintedArticleDto> getAllArticles();
}