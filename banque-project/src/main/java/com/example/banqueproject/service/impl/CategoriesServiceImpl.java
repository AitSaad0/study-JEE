package com.example.banqueproject.service.impl;

import com.example.banqueproject.dao.impl.CategoriesDAOImpl;
import com.example.banqueproject.dao.inte.CategoriesDao;
import com.example.banqueproject.entity.Categories;
import com.example.banqueproject.service.CategoriesService;

import java.util.Comparator;
import java.util.List;

public class CategoriesServiceImpl implements CategoriesService {
    private CategoriesDao categoriesDao = new CategoriesDAOImpl();

    @Override
    public List<Categories> getAllCategories() {
        List<Categories> categories = categoriesDao.findAll();

        categories.sort(Comparator.comparing(Categories::getCat, String.CASE_INSENSITIVE_ORDER));

        return categories;
    }
}
