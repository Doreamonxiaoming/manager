package com.training.manager.service;

import com.training.manager.dao.CategoryRepository;
import com.training.manager.dao.TransactionRepository;
import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import com.training.manager.pojo.NewCategory;
import com.training.manager.pojo.TransactionCategory;
import com.training.manager.pojo.TransactionRaw;
import com.training.manager.pojo.TransactionResult;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.awt.font.TransformAttribute;
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
    @Autowired
    CategoryRepository categoryRepo;

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


//    /*Post*/
//    // create a transaction
//    @Override
//    public void addTransaction(TransactionRaw transactionRaw) {
//        Integer categoryId=transactionRaw.getCategoryId();
//        Category newCategory=categoryRepo.findById(categoryId).get();
//        Transaction transaction=new Transaction().builder().
////                id(transactionRaw.getId()).
//                name(transactionRaw.getName()).
//                amount(transactionRaw.getAmount()).
//                transactTime(transactionRaw.getTransactTime()).
//                detail(transactionRaw.getDetail()).
//                category(newCategory).build();
//        transactionRepo.save(transaction);
//    }


    /*Post*/
    // create a transaction
    @Override
    public void addTransaction(TransactionCategory transactionCategory) {
        NewCategory newCategory=transactionCategory.getCategory();
        Category category=new Category().builder().
                id(newCategory.getValue()).
                name(newCategory.getLabel()).
                budget(newCategory.getBudget()).build();

        Transaction transaction=new Transaction().builder().
                        name(transactionCategory.getName()).
                        amount(transactionCategory.getAmount()).
                        transactTime(transactionCategory.getTransactTime()).
                        detail(transactionCategory.getDetail()).
                        category(category).build();
        transactionRepo.save(transaction);
    }


    /*Put*/
    // update a transaction
    @Override
   public void putTransaction(Integer transactionId,TransactionRaw transactionRaw) {
//        transactionRepo.saveById(transactionId);
        Transaction transaction=transactionRepo.findById(transactionId).get();
        Category category=categoryRepo.findById(transactionRaw.getCategoryId()).get();
//        Transaction newTransaction=new Transaction().builder().
//                id(transactionId).
//                name(transactionRaw.getName()).
//                amount(transactionRaw.getAmount()).
//                transactTime(transactionRaw.getTransactTime()).
//                detail(transactionRaw.getDetail()).
//                category(category).build();
        transaction.setId(transactionId);
        transaction.setName(transactionRaw.getName());
        transaction.setAmount(transactionRaw.getAmount());
        transaction.setTransactTime(transactionRaw.getTransactTime());
        transaction.setDetail(transactionRaw.getDetail());
        transaction.setCategory(category);
        transactionRepo.save(transaction);
    }

    /*Delete-删*/
    // delete one transaction
    @Override
    public void deleteOneTransaction(Integer transactionID) {
        transactionRepo.deleteById(transactionID);
    }


    /*GetExpenses*/
    @Override
    public BigDecimal getExpenses() {
        return transactionRepo.sumByAmount();
    }

    /*GetBills*/
    public BigDecimal getBills(){
        return transactionRepo.sumByAmountWhereUtilities();
    }


}
