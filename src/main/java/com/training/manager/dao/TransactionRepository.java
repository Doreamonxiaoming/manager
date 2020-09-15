package com.training.manager.dao;

import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer>, JpaSpecificationExecutor<Transaction> {
    List<Transaction> findByTransactTimeBetween(Date start, Date end);

//    List<Transaction> findByCategoryId(Integer categoryId);
//
//    BigDecimal sumByAmount();
}
