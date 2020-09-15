package com.training.manager.service;

import com.training.manager.model.Transaction;
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
//    void addTransaction(Transaction transaction,Integer categoryId);

    /*Put*/
    // update a transaction
    void putTransaction(Integer transactionId,Transaction transaction);

//    void putTransaction(Integer transactionId);


    /*Delete-删*/
    // delete one transaction
    void deleteOneTransaction(Integer transactionID);


    //return all transactions by categoryId
//    List<Transaction> getTransactionsByCategoryId(Integer categoryId);

    //return all transactions by date range
//    List<Transaction> getTransactionsByDateRange(Date startDate, Date endDate);

    /*Sum*/
    // get total expenses or get total expenses by date range
//    BigDecimal getExpensesSumByTransactAmount();


}
