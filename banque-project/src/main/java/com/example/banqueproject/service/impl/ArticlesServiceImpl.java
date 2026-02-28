package com.example.banqueproject.service.impl;

import com.example.banqueproject.dao.impl.ArticlesDAOImpl;
import com.example.banqueproject.dao.inte.ArticlesDAO;
import com.example.banqueproject.dto.ArticlesDto;
import com.example.banqueproject.service.ArticlesService;

import java.util.List;
import java.util.NoSuchElementException;

public class ArticlesServiceImpl implements ArticlesService {
    ArticlesDAO articlesDAO = new ArticlesDAOImpl();

    @Override
    public List<ArticlesDto> getAllArticlesByCategory(int idCat) {
        List<ArticlesDto> articles = articlesDAO.findByCategorie(idCat);
        if (articles.isEmpty()) {
            throw new NoSuchElementException("No articles found");
        }
        return articles;
    }

    @Override
    public List<ArticlesDto> getAllArticles() {
        List<ArticlesDto> articles = articlesDAO.findAll();
        if (articles.isEmpty()) {
            throw new NoSuchElementException("No articles found");
        }
        return articles;
    }
}