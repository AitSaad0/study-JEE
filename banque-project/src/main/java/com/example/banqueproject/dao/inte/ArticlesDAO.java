package com.example.banqueproject.dao.inte;

import com.example.banqueproject.dto.ArticlesDto;


import java.util.List;

public interface ArticlesDAO {
    public List<ArticlesDto> findByCategorie(int idCat);
    public List<ArticlesDto> findAll();
}
