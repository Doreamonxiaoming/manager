package com.training.manager.controller;

import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import com.training.manager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    //return all transactions
    @GetMapping(value = "/allTransaction", produces = {"application/json", "application/xml"})
    public List<Transaction> getAllCategory (){
        return transactionService.getAllTransaction();
    }

    //return one transaction details
    @GetMapping(value = "/oneTransaction/{categoryID}", produces = {"application/json", "application/xml"})
    public Optional<Transaction> getOneCategory (@PathVariable Integer transactionID) {
        return transactionService.getOneTransaction(transactionID);
    }

    //get total categorical transaction
    @GetMapping(value = "/categoricalTransaction/{categoryID}", produces = {"application/json", "application/xml"})
    public BigDecimal categoryTotal (@PathVariable Integer categoryID) {
        return transactionService.getAllTransaction(categoryID);
    }

    //get total categorical transaction with date range

    //get total expense or get total expense by date range

    //get total bill or get total bill by date range

    //get total income or get total income by date range

    //add a transaction
    @PutMapping(value="/addTransaction", consumes={"application/json","application/xml"})
    public ResponseEntity addTransaction (@RequestBody Transaction transaction) {
        if (!transactionService.isTransaction(transaction)) {
            return ResponseEntity.notFound().build();
        }
        else {
            transactionService.addTransaction(transaction);
            return ResponseEntity.ok().build();
        }
    }

    //delete one transaction
    @DeleteMapping("/{transactionID}")
    public ResponseEntity deleteCategory(@PathVariable Integer transactionID) {
        if (!transactionService.isTransactionID(transactionID)) {
            return ResponseEntity.notFound().build();
        }
        else {
            transactionService.deleteTransaction(transactionID);
            return ResponseEntity.ok().build();
        }
    }


}
