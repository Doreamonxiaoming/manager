package com.training.manager.controller;

import com.training.manager.model.Category;
import com.training.manager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/allCategory", produces = {"application/json", "application/xml"})
    public List<Category> getAllCategory (){
        return categoryService.getAllCategory();
    }

    @GetMapping(value = "/oneCategory/{categoryID}", produces = {"application/json", "application/xml"})
    public Category getOneCategory (@PathVariable Integer categoryID) {
        return categoryService.getOneCategory(categoryID);
    }

    @PutMapping(value="/addCategory", consumes={"application/json","application/xml"})
    public ResponseEntity addCategory (@RequestBody Category category) {
        if (!categoryService.isCategory(category)) {
            return ResponseEntity.notFound().build();
        }
        else {
            categoryService.addCategory(category);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/{categoryID}")
    public ResponseEntity deleteCategory(@PathVariable Integer categoryID) {
        if (!categoryService.isCategoryID(categoryID)) {
            return ResponseEntity.notFound().build();
        }
        else {
            categoryService.deleteCategory(categoryID);
            return ResponseEntity.ok().build();//如果真的delete了，那属于这个category的其他transaction怎么处理？担心transaction那边没有这个category报错
        }
    }



}
