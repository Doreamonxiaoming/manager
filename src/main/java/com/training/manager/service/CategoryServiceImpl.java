package com.training.manager.service;

import com.training.manager.dao.CategoryRepository;
import com.training.manager.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepo;

    //return all categories
    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    //return one category details
    @Override
    public Optional<Category> getOneCategory(Integer id) {
        return categoryRepo.findById(id);
    }

    //add one new category
    @Override
    public void addCategory(Category category) {
        categoryRepo.save(category);

    }
    //check status when adding new category
    @Override
    public boolean isCategory(Category category) {
        return false;//？？这里需要查询在现在在个数据库里是否有这个category
    }

    //delete one category
    @Override
    public void deleteCategory(Integer ID) {
        categoryRepo.deleteById(ID);
    }

    //check status when deleted one category
    @Override
    public boolean isCategoryID(Integer categoryID) {
        return false;//？？这里需要查询在现在在个数据库里是否有这个categoryID
    }



}
