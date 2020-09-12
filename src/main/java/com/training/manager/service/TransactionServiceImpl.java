package com.training.manager.service;

import com.training.manager.dao.TransactionRepository;
import com.training.manager.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class TransactionServiceImpl implements TransactionService{


    @Autowired
    TransactionRepository transactionRepo;

    //return all transactions
    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepo.findAll();
    }

    //return one transaction details
    @Override
    public Optional<Transaction> getOneTransaction(Integer id) {
        return transactionRepo.findById(id);
    }

    //get total categorical transaction
    @Override
    public BigDecimal getAllTransaction(Integer categoryID) {
        return null;//SELECT * WHERE CategoryID = ''
    }

    //get total categorical transaction with date range
    @Override
    public BigDecimal getAllTransaction(Integer categoryID, Date startDate, Date endDate) {
        return null;//SELECT * WHERE CategoryID = '' and Date <= startDate & Date >= endDate
    }

    //get total expense or get total expense by date range
    @Override
    public BigDecimal getExpense() {
        return null;//SELECT SUM() WHERE amount < 0
    }

    @Override
    public BigDecimal getExpense(Date startDate, Date endDate) {
        return null;//SELECT SUM() WHERE amount < 0 & Date <= startDate & Date >= endDate
    }

    //get total bill or get total bill by date range
    @Override
    public BigDecimal getBill() {
        return null;//SELECT SUM() WHERE CategoryID = 'Utilities'
    }

    @Override
    public BigDecimal getBill(Date startDate, Date endDate) {
        return null;//SELECT SUM() WHERE CategoryID = 'Utilities' & Date <= startDate & Date >= endDate
    }

    //get total income or get total income by date range
    @Override
    public BigDecimal getIncome() {
        return null;//SELECT SUM() WHERE amount > 0
    }

    @Override
    public BigDecimal getIncome(Date startDate, Date endDate) {
        return null;//SELECT SUM() WHERE amount > 0 & Date <= startDate & Date >= endDate
    }

    //add a transaction
    @Override
    public void addTransaction(Transaction transaction) {
        transactionRepo.save(transaction);
    }

    //check status when adding new transaction
    @Override
    public boolean isTransaction(Transaction transaction) {
        return false;//？？这里需要查询在现在在个数据库里是否有这个transaction
    }

    //delete one transaction
    @Override
    public void deleteTransaction(Integer ID) {
        transactionRepo.deleteById(ID);
    }

    //check status when deleted one transaction
    @Override
    public boolean isTransactionID(Integer ID) {
        return false;//？？这里需要查询在现在在个数据库里是否有这个transactionID
    }
}
