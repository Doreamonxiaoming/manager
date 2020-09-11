package com.training.manager.controller;

import com.training.manager.dao.CategoryRepository;
import com.training.manager.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categorys")
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

}
