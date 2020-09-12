package com.training.manager.service;

import com.training.manager.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionService {
    //return all transactions
    List<Transaction> getAllTransaction();

    //return one transaction details
    Optional<Transaction> getOneTransaction(Integer id);

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

    //add a transaction
    void addTransaction(Transaction transaction);
    //check status when adding new transaction
    boolean isTransaction(Transaction transaction);

    //delete one transaction
    void deleteTransaction(Integer ID);
    //check status when deleted one transaction
    boolean isTransactionID(Integer ID);
}
