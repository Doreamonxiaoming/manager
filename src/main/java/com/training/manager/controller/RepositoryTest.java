package com.training.manager.controller;

import com.training.manager.dao.CategoryRepository;
import com.training.manager.dao.TransactionRepository;
import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    public Optional<Category> getOneCategory(){
        return categoryRepository.findById(1);
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransaction(){
        return transactionRepository.findAll();
    }

    @GetMapping("/transactions/one")
    public Optional<Transaction> getOneTransaction(){
        return transactionRepository.findById(1);
    }
}
