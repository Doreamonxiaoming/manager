package com.training.manager.service;

import com.training.manager.dao.CategoryRepository;
import com.training.manager.dao.TransactionRepository;
import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import com.training.manager.pojo.NewCategory;
import com.training.manager.pojo.TransactionCategory;
import com.training.manager.pojo.TransactionRaw;
import com.training.manager.pojo.TransactionResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class TransactionServiceImplTest {
    @InjectMocks
    TransactionServiceImpl transactionService;
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    CategoryRepository categoryRepository;

    Transaction transaction;
    Category category;
    List<Transaction> transactions;
    @Before
    public void setUp() {
        //在单元测试之前，执行Mockito的注解扫描，并注入依赖
        MockitoAnnotations.initMocks(this);

        // mock database result
        transaction = new Transaction().builder().id(1).name("test").amount(new BigDecimal(100)).detail("test").build();
        category = new Category().builder().id(1).name("Utilities").budget(new BigDecimal(100)).transactions(new HashSet<>()).build();
        transaction.setCategory(category);
        category.getTransactions().add(transaction);
        transactions=new ArrayList<>();
        transactions.add(transaction);
    }


    //GetAllTransaction
    @Test
    public void getAllTransaction() {
        //mock findAll() action
        Mockito.when(transactionRepository.findAll()).thenReturn(transactions);

        //mock expected result
        List<TransactionResult> transactionResults=new ArrayList<>();
        TransactionResult transactionResult=new TransactionResult().builder().
                id(1).
                name("test").
                amount(new BigDecimal(100)).
                detail("test").
                categoryName("Utilities").build();
        transactionResults.add(transactionResult);

        //validate
        assertEquals(transactionResults,transactionService.getAllTransaction());
    }


    //GetOneTransaction
    @Test
    public void getOneTransaction() {
        //mock findById() action
        Mockito.when(transactionRepository.findById(1)).thenReturn(Optional.of(transaction));

        TransactionResult transactionResult=new TransactionResult().builder().
                id(1).
                name("test").
                amount(new BigDecimal(100)).
                detail("test").
                categoryName("Utilities").build();
        assertEquals(transactionResult,transactionService.getOneTransaction(1));

//        assertEquals(1,transactionService.getOneTransaction(1).getId().intValue());
    }

    //GetExpenses
    @Test
    public void getExpenses(){
        //mock sunByAmount() action
        Mockito.when(transactionRepository.sumByAmount()).thenReturn(new BigDecimal(100));

        //validate
        assertEquals(new BigDecimal(100),transactionService.getExpenses());
    }

    //GetBills
    @Test
    public void getBills(){
        //mock sumByAmountWhereUtilities() action
        Mockito.when(transactionRepository.sumByAmountWhereUtilities()).thenReturn(new BigDecimal(100));

        //validate
        assertEquals(new BigDecimal(100),transactionService.getBills());
    }


    //Post
    @Test
    public void addTransaction() {
        NewCategory newCategory=new NewCategory().builder().
                value(category.getId()).
                label(category.getName()).build();
        TransactionCategory transactionCategory=new TransactionCategory().builder().
                name("test").
                amount(new BigDecimal(100)).
                detail("test").
                category(newCategory).build();

        Category category=new Category().builder().id(newCategory.getValue()).name(newCategory.getLabel()).budget(null).build();

        Transaction transaction1=new Transaction().builder().
                id(1).
                name("test").
                amount(new BigDecimal(100)).detail("test").category(category).build();

        transactionService.addTransaction(transactionCategory);
    }

    //Put
    @Test
    public void putTransaction(){
        //mock findById() action
        Mockito.when(transactionRepository.findById(1)).thenReturn(Optional.ofNullable(transaction));
        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.ofNullable(category));

        //mock expected result
        TransactionRaw transactionRaw=new TransactionRaw().builder().
                name("test").
                amount(new BigDecimal(101)).
                detail("test").
                categoryId(1).build();

        transactionService.putTransaction(1,transactionRaw);
        verify(transactionRepository).save(transaction);
    }

    //Delete
    @Test
    public void deleteOneTransaction() {
        transactionService.deleteOneTransaction(1);
        verify(transactionRepository).deleteById(1);
    }

}