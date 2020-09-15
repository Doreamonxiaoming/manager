package com.training.manager.service;

import com.training.manager.model.Transaction;
import com.training.manager.pojo.TransactionResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    /*Get*/
    // return all transactions(all categories)
    List<TransactionResult> getAllTransaction();

    //return one transaction details based on the transactionId
    Transaction getOneTransaction(Integer transactionId);

    //return all transactions by categoryId
//    List<Transaction> getTransactionsByCategoryId(Integer categoryId);

    //return all transactions by date range
//    List<Transaction> getTransactionsByDateRange(Date startDate, Date endDate);

    /*Sum*/
    // get total expenses or get total expenses by date range
//    BigDecimal getExpensesSumByTransactAmount();


    /*Post*/
    // create/update a transaction
    void addTransaction(Transaction transaction);

    /*Delete-删*/
    // delete one transaction
    void deleteOneTransaction(Integer transactionID);


    //get total categorical transaction (date range)
    BigDecimal getAllTransaction(Integer categoryID);
    BigDecimal getAllTransaction(Integer categoryID, Date startDate, Date endDate);

    //get total expense or get total expense by date range
    BigDecimal getExpense();
    BigDecimal getExpense(Date startDate, Date endDate);

    //get total bill or get total bill by date range
    BigDecimal getBill();
    BigDecimal getBill(Date startDate, Date endDate);

    //get total income or get total income by date range
    BigDecimal getIncome();
    BigDecimal getIncome(Date startDate, Date endDate);




    //check status when deleted one transaction
    boolean isTransactionID(Integer ID);
}
