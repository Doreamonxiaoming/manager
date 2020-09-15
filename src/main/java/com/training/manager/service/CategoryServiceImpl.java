package com.training.manager.service;

import com.training.manager.dao.CategoryRepository;
import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepo;

    //return all categories
    @Override
    public List<Category> getAllCategory() {
//        for (Category c : categoryRepo.findAll()) {
//            BigDecimal result  = new BigDecimal(0);
//            for (Transaction t : c.getTransactions()) {
//                result = result.add(t.getAmount());
//                System.out.println(t.getAmount());
////                System.out.println(t.getCategory());
//            }
//            System.out.println(result);
//            System.out.println("-----------");
//            c.setCost(result);
//        }

//        List<String> name;
//        name.add(c);

//        List<Category> categoryList = categoryRepo.findAll();
        return categoryRepo.findAll();
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
    //check status when adding new category
    @Override
    public boolean isCategory(Category category) {
        return categoryRepo.existsById(category.getId());
    }

    //delete one category
    @Override
    public void deleteCategory(Integer ID) {
        categoryRepo.deleteById(ID);
    }

    //check status when deleted one category
    @Override
    public boolean isCategoryID(Integer categoryID) {
        return categoryRepo.existsById(categoryID);
    }
}
