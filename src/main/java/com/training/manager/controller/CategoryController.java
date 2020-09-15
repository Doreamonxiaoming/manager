package com.training.manager.controller;

import com.training.manager.model.Category;
import com.training.manager.pojo.CategoryRaw;
import com.training.manager.pojo.CategoryResult;
import com.training.manager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping(produces = {"application/json", "application/xml"})
    public List<CategoryResult> getAllCategory (){
        return categoryService.getAllCategory();
    }


    @GetMapping(value = "/{categoryID}", produces = {"application/json", "application/xml"})
    public Category getOneCategory (@PathVariable Integer categoryID) {
        return categoryService.getOneCategory(categoryID);
    }

    @PostMapping(consumes={"application/json","application/xml"})
    public ResponseEntity addCategory (@RequestBody CategoryRaw categoryRaw) {
        String name = categoryRaw.getName();
        BigDecimal budget = categoryRaw.getBudget();
        Category category = new Category(name, budget);
        categoryService.addCategory(category);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value="/{categoryID}", consumes = {"application/json","application/xml"})
    public ResponseEntity modifyCategory(@PathVariable Integer categoryID, @RequestBody Category category) {
        categoryService.modifyCategory(categoryID, category);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{categoryID}")
    public ResponseEntity deleteCategory(@PathVariable Integer categoryID) {
        categoryService.deleteCategory(categoryID);
        return ResponseEntity.ok().build();
    }
}
