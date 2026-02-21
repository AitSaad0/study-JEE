package com.example.banqueproject.service.impl;

import com.example.banqueproject.dao.impl.ArticlesDAOImpl;
import com.example.banqueproject.dao.inte.ArticlesDAO;
import com.example.banqueproject.dto.ArticlesDto;
import com.example.banqueproject.dto.PrintedArticleDto;
import com.example.banqueproject.dto.mapper.ArticlesMapper;
import com.example.banqueproject.dto.mapper.PrintedArticleMapper;
import com.example.banqueproject.service.ArticlesService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ArticlesServiceImpl implements ArticlesService {
    ArticlesDAO articlesDAO = new ArticlesDAOImpl();

    @Override
    public List<PrintedArticleDto> getAllArticlesByCategory(int idCat){
        List<PrintedArticleDto> articles = articlesDAO.findByCategorie(idCat)
                .stream()
                .map(PrintedArticleMapper::fromDto)
                .toList();
        if(articles.isEmpty()){
            throw new NoSuchElementException("No articles found");
        }

        return articles;
    }

    @Override
    public List<PrintedArticleDto> getAllArticles() {
        List<PrintedArticleDto> articles = articlesDAO.findAll()
                .stream()
                .map(PrintedArticleMapper::fromDto)
                .toList();
        if(articles.isEmpty()){
            throw new NoSuchElementException("No articles found");
        }
        return articles;
    }
}
