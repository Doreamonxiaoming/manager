package com.training.manager.service;

import com.training.manager.model.Transaction;
import com.training.manager.pojo.TransactionCategory;
import com.training.manager.pojo.TransactionRaw;
import com.training.manager.pojo.TransactionResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    /*Get*/
    // return all transactions
    List<TransactionResult> getAllTransaction();

    //return one transaction details based on the transactionId
    TransactionResult getOneTransaction(Integer transactionId);


//    /*Post*/
//    // create a transaction
//    void addTransaction(TransactionRaw transactionRaw);

    /*Post*/
    // create a transaction
    void addTransaction(TransactionCategory transactionCategory);


    /*Put*/
    // update a transaction
    void putTransaction(Integer transactionId,TransactionRaw transactionRaw);


    /*Delete-删*/
    // delete one transaction
    void deleteOneTransaction(Integer transactionID);

    /*GetExpenses*/
    BigDecimal getExpenses();


    /*GetBills*/
    BigDecimal getBills();



}
