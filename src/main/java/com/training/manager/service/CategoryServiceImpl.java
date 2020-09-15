package com.training.manager.service;

import com.training.manager.dao.CategoryRepository;
import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import com.training.manager.pojo.CategoryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepo;

    //return all categories
    @Override
    public List<CategoryResult> getAllCategory() {
        List<Category> categoryList = categoryRepo.findAll();
        List<CategoryResult> categoryResultList = new ArrayList<>();
        for (Category c : categoryList) {
            BigDecimal result  = new BigDecimal(0);
            for (Transaction t : c.getTransactions()) {
                result = result.add(t.getAmount());
            }
            CategoryResult categoryResult = new CategoryResult(c.getId(), c.getName(), c.getBudget(), result);
            categoryResultList.add(categoryResult);
        }
        return categoryResultList;
    }

    //return one category details
    @Override
    public Category getOneCategory(Integer id) {
        return categoryRepo.findById(id).get();
    }

    //add one new category
    @Override
    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    //delete one category
    @Override
    public void deleteCategory(Integer ID) {
        categoryRepo.deleteById(ID);
    }

    @Override
    public void modifyCategory(Integer ID, Category newCategory) {
        Category category = categoryRepo.findById(ID).get();
        category.setId(ID);
        category.setBudget(newCategory.getBudget());
        category.setName(newCategory.getName());
        category.setTransactions(newCategory.getTransactions());
        categoryRepo.save(category);
    }
}
