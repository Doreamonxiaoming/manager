package com.training.manager.service;

import com.training.manager.dao.TransactionRepository;
import com.training.manager.model.Transaction;
import com.training.manager.pojo.TransactionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepo;

    /*Get-查*/
    //return all transactions
    @Override
    public List<TransactionResult> getAllTransaction() {
        List<Transaction> transactions=transactionRepo.findAll();
        List<TransactionResult> transactionResults=new ArrayList<>();


        return transactionResults;
    }

    //return one transaction details
    @Override
    public Transaction getOneTransaction(Integer transactionId) {
        return transactionRepo.findById(transactionId).get();
    }

    //return all transactions by categoryId
//    @Override
////    @Query(value = "select id,name,transact_time,amount,detail from tb_transaction tr where tr.category_id=:categoryId")
//    public List<Transaction> getTransactionsByCategoryId(Integer categoryId){
////        return (List<Transaction>) transactionRepo.findAll().get(categoryId);
//        return transactionRepo.findByCategoryId(categoryId);
//    }

    //return all transactions by date range
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    public List<Transaction> getTransactionsByDateRange(Date startDate, Date endDate){
//        return transactionRepo.findByTransactTimeBetween(startDate, endDate);
//    }


    /*Post-增+改*/
    // create/update a transaction
    @Override
    public void addTransaction(Transaction transaction) {
        transactionRepo.save(transaction);
    }

    /*Delete-删*/
    // delete one transaction
    @Override
    public void deleteOneTransaction(Integer transactionID) {
        transactionRepo.deleteById(transactionID);
    }

    /*Sum*/
    // get total expenses or get total expenses by date range
//    @Override
//    public BigDecimal getExpensesSumByTransactAmount() {
//        return transactionRepo.sumByAmount();
//    }







    //check status when deleted one transaction
    @Override
    public boolean isTransactionID(Integer ID) {
        return false;//？？这里需要查询在现在在个数据库里是否有这个transactionID
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


}
