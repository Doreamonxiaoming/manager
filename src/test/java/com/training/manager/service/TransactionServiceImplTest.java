package com.training.manager.service;

import com.training.manager.model.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TransactionServiceImplTest {
    @Autowired
    TransactionService transactionService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllTransaction() {
//        transactionService.getAllTransaction().toString();
    }

    @Test
    public void getOneTransaction() {
    }

    @Test
    public void getTransactionsByCategoryId() {
    }

    @Test
    public void getTransactionsByDateRange() {
    }

    @Test
    public void addTransaction() {
    }

    @Test
    public void deleteOneTransaction() {
    }

    @Test
    public void getExpensesSumByTransactAmount(){
//        System.out.println(transactionService.getExpensesSumByTransactAmount().doubleValue());
    }
}