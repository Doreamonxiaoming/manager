package com.training.manager.service;

import com.training.manager.dao.TransactionRepository;
import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.*;

public class TransactionServiceImplTest {
    @InjectMocks
    TransactionServiceImpl transactionService;
    @Mock
    TransactionRepository transactionRepository;

    Transaction transaction;
    Category category;
    @Before
    public void setUp() {
        //在单元测试之前，执行Mockito的注解扫描，并注入依赖
        MockitoAnnotations.initMocks(this);

        // mock database result
        transaction = new Transaction().builder().id(1).name("test").amount(new BigDecimal(100)).detail("test").build();
        category = new Category().builder().id(1).name("test").budget(new BigDecimal(100)).transactions(new HashSet<>()).build();
        transaction.setCategory(category);
        category.getTransactions().add(transaction);
    }

    @Test
    public void getAllTransaction() {
//        transactionService.getAllTransaction().toString();
    }

    @Test
    public void getOneTransaction() {
        Mockito.when(transactionRepository.findById(1)).thenReturn(Optional.of(transaction));

        assertEquals(1,transactionService.getOneTransaction(1).getId().intValue());
    }

//    @Test
//    public void getTransactionsByCategoryId() {
//    }

//    @Test
//    public void getTransactionsByDateRange() {
//    }

    @Test
    public void addTransaction() {
    }

    @Test
    public void deleteOneTransaction() {
    }

//    @Test
//    public void getExpensesSumByTransactAmount(){
////        System.out.println(transactionService.getExpensesSumByTransactAmount().doubleValue());
//    }
}