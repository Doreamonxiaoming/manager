package com.training.manager.service;

import com.training.manager.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepo repository;
}
