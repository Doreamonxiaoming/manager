package com.training.manager.controller;

import com.training.manager.dao.CategoryRepository;
import com.training.manager.dao.TransactionRepository;
import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/categorys")
    public List<Category> getAllCategorys(){
        return categoryRepository.findAll();
    }

    @GetMapping("/categorys/one")
    public Category getOneCategory(){
        System.out.println(categoryRepository.findById(1).get());
        return categoryRepository.findById(1).get();
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransaction(){
        return transactionRepository.findAll();
    }

    @GetMapping("/transactions/one")
    public Transaction getOneTransaction(){
        return transactionRepository.findById(1).get();
    }
}
