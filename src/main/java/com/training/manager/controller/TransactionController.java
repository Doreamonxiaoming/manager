package com.training.manager.controller;

import com.training.manager.model.Transaction;
import com.training.manager.pojo.TransactionCategory;
import com.training.manager.pojo.TransactionRaw;
import com.training.manager.pojo.TransactionResult;
import com.training.manager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    /*Get*/
    // return all transactions
    @GetMapping(produces = {"application/json", "application/xml"})
    public List<TransactionResult> getAllCategory (){
        return transactionService.getAllTransaction();
    }

    //return one transaction details
    @GetMapping(value = "/{transactionID}", produces = {"application/json", "application/xml"})
    public TransactionResult getOneCategory (@PathVariable Integer transactionID) {
        return transactionService.getOneTransaction(transactionID);
    }

    //return all transactions by categoryId
//    @GetMapping(value = "/allTransactionsByCategory/{categoryId}", produces = {"application/json", "application/xml"})
//    public List<Transaction> getTransactionsByCategoryId(@PathVariable Integer categoryId){
//        return transactionService.getTransactionsByCategoryId(categoryId);
//    }

    //return all transactions by date range
//    @GetMapping(value = "/allTransactionsByDateRange/{startDate,endDate}",produces = {"application/json", "application/xml"})
//    public List<Transaction> getTransactionsByDateRange(@PathVariable Date startDate, @PathVariable Date endDate){
//        return transactionService.getTransactionsByDateRange(startDate,endDate);
//    }

//    /*Post*/
//    //add a transaction
//    @PostMapping(consumes={"application/json","application/xml"})
//    public ResponseEntity addTransaction (@RequestBody TransactionRaw transactionRaw) {
////        if (!transactionService.isTransaction(transaction)) {
////            return ResponseEntity.notFound().build();
////        }
////        else {
//        transactionService.addTransaction(transactionRaw);
//        return ResponseEntity.ok().build();
////        }
//    }


    /*Post*/
    //add a transaction
    @PostMapping(consumes={"application/json","application/xml"})
    public ResponseEntity addTransaction (@RequestBody TransactionCategory transactionCategory) {
        transactionService.addTransaction(transactionCategory);
        return ResponseEntity.ok().build();
    }


    /*Put*/
    // update a transaction
    @PutMapping(value="/{transactionID}", consumes={"application/json","application/xml"})
    public ResponseEntity putTransaction (@PathVariable Integer transactionID,@RequestBody TransactionRaw transactionRaw) {
//        if (!transactionService.isTransaction(transaction)) {
//            return ResponseEntity.notFound().build();
//        }
//        else {
        transactionService.putTransaction(transactionID,transactionRaw);
        return ResponseEntity.ok().build();
//        }
    }

    /*Delete*/
    //delete one transaction
    @DeleteMapping("/{transactionID}")
    public ResponseEntity deleteOneTransaction(@PathVariable Integer transactionID) {
//        if (!transactionService.isTransactionID(transactionID)) {
//            return ResponseEntity.notFound().build();
//        }
//        else {
        transactionService.deleteOneTransaction(transactionID);
        return ResponseEntity.ok().build();
//        }
    }


    /*GetExpenses*/
    @GetMapping(value = "/expenses",produces = {"application/json", "application/xml"})
    public BigDecimal getExpenses(){
        return transactionService.getExpenses();
    }


    /*GetBills*/
    @GetMapping(value = "/bills",produces = {"application/json", "application/xml"})
    public BigDecimal getBills(){
        return transactionService.getBills();
    }



}
