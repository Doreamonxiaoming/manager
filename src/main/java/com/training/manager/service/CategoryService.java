package com.training.manager.service;

import com.training.manager.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    //return all categories
    List<Category> getAllCategory();

    //return one category details
    Category getOneCategory(Integer id);

    //add one new category
    void addCategory(Category category);
    //check status when adding new category
    boolean isCategory(Category category);

    //delete one category
    void deleteCategory(Integer ID);
    //check status when deleted one category
    boolean isCategoryID(Integer ID);


}
