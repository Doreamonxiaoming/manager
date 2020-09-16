package com.training.manager.service;

import com.training.manager.dao.CategoryRepository;
import com.training.manager.dao.TransactionRepository;
import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import com.training.manager.pojo.TransactionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
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
    // return all transactions
    @Override
    public List<TransactionResult> getAllTransaction() {
        List<Transaction> transactions=transactionRepo.findAll();
        List<TransactionResult> transactionResultsList=new ArrayList<>();
        for(Transaction t:transactions){
//            TransactionResult transactionResults;
//            if(t.getCategory().getName().equals(null)){
//                transactionResults = new TransactionResult(t.getId(), t.getName(), t.getTransactTime(), t.getAmount(), t.getDetail(), null);
//            }else{
//                transactionResults = new TransactionResult(t.getId(), t.getName(), t.getTransactTime(), t.getAmount(), t.getDetail(), t.getCategory().getName());
//            }
            TransactionResult transactionResults=new TransactionResult(t.getId(), t.getName(), t.getTransactTime(), t.getAmount(), t.getDetail(), t.getCategory().getName());
            transactionResultsList.add(transactionResults);
        }
        return transactionResultsList;
    }

    //return one transaction details
    @Override
    public TransactionResult getOneTransaction(Integer transactionId) {
        Transaction transaction=transactionRepo.findById(transactionId).get();
        TransactionResult transactionResult=new TransactionResult(transaction.getId(),transaction.getName(),transaction.getTransactTime(),transaction.getAmount(),transaction.getDetail(),transaction.getCategory().getName());
        return transactionResult;
    }


    /*Post*/
    // create a transaction
    @Override
    public void addTransaction(Transaction transaction,Integer categoryId) {
//        Category category=transaction.getCategory();
//        category.setId(categoryId);
//        Transaction transaction1=new Transaction(transaction.getId(),transaction.getName(),transaction.getTransactTime(),transaction.getAmount(),transaction.getDetail(),category);
////        transaction.getCategory().setId(categoryId);
//        transactionRepo.save(transaction1);
        transactionRepo.save(transaction);
    }

    /*Put*/
    // update a transaction
    @Override
   public void putTransaction(Integer transactionId,Transaction newTransaction) {
//        transactionRepo.saveById(transactionId);
        Transaction transaction=transactionRepo.findById(transactionId).get();
        transaction.setId(transactionId);
        transaction.setName(newTransaction.getName());
        transaction.setAmount(newTransaction.getAmount());
        transaction.setTransactTime(newTransaction.getTransactTime());
        transaction.setDetail(newTransaction.getDetail());
        transaction.setCategory(newTransaction.getCategory());
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


}
