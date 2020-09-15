package com.training.manager.controller;

import com.training.manager.model.Transaction;
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
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    /*Get*/
    // return all transactions
    @GetMapping(value = "/allTransaction", produces = {"application/json", "application/xml"})
    public List<TransactionResult> getAllCategory (){
        return transactionService.getAllTransaction();
    }

    //return one transaction details
    @GetMapping(value = "/oneTransaction/{transactionID}", produces = {"application/json", "application/xml"})
    public Transaction getOneCategory (@PathVariable Integer transactionID) {
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

    /*Post*/
    //add a transaction
    @PostMapping(value="/addTransaction", consumes={"application/json","application/xml"})
    public ResponseEntity addTransaction (@RequestBody Transaction transaction) {
//        if (!transactionService.isTransaction(transaction)) {
//            return ResponseEntity.notFound().build();
//        }
//        else {
        transactionService.addTransaction(transaction);
        return ResponseEntity.ok().build();
//        }
    }

    /*Put*/
    // update a transaction
    @PutMapping(value="/putTransaction/{transactionId}", consumes={"application/json","application/xml"})
    public ResponseEntity putTransaction (@PathVariable Integer transactionId,@RequestBody Transaction transaction) {
//        if (!transactionService.isTransaction(transaction)) {
//            return ResponseEntity.notFound().build();
//        }
//        else {
        transactionService.putTransaction(transactionId,transaction);
        return ResponseEntity.ok().build();
//        }
    }

    /*Delete*/
    //delete one transaction
    @DeleteMapping("/deleteOneTransaction/{transactionID}")
    public ResponseEntity deleteOneTransaction(@PathVariable Integer transactionID) {
//        if (!transactionService.isTransactionID(transactionID)) {
//            return ResponseEntity.notFound().build();
//        }
//        else {
        transactionService.deleteOneTransaction(transactionID);
        return ResponseEntity.ok().build();
//        }
    }

    /*Sum*/
    // get total expenses or get total expenses by date range
//    @GetMapping(value = "/allExpenses", produces = {"application/json", "application/xml"})
//   public BigDecimal getExpensesSumByTransactAmount(){
//       return transactionService.getExpensesSumByTransactAmount();
//   }




    //get total categorical transaction
//    @GetMapping(value = "/categoricalTransaction/{categoryID}", produces = {"application/json", "application/xml"})
//    public BigDecimal categoryTotal (@PathVariable Integer categoryID) {
//        return transactionService.getAllTransaction(categoryID);
//    }

    //get total categorical transaction with date range

    //get total expense or get total expense by date range

    //get total bill or get total bill by date range

    //get total income or get total income by date range




}
