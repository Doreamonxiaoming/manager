package com.training.manager.service;

import com.training.manager.model.Category;
import com.training.manager.pojo.CategoryResult;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    //return all categories
    List<CategoryResult> getAllCategory();

    //return one category details
    Category getOneCategory(Integer id);

    //add one new category
    void addCategory(Category category);

    //delete one category
    void deleteCategory(Integer ID);

    //modify one category
    void modifyCategory(Integer ID, Category category);

    //get total budget
    BigDecimal totalBudget();
}
