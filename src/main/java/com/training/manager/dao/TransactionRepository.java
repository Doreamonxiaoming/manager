package com.training.manager.dao;

import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer>, JpaSpecificationExecutor<Transaction> {
    List<Transaction> findByTransactTimeBetween(Date start, Date end);

//    @Query("select sum(t.amount) from tb_transaction t")
//    BigDecimal sumByAmount();
}
