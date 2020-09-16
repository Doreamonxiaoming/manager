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

    @Query(value = "select sum(amount) from tb_transaction", nativeQuery = true)
    BigDecimal sumByAmount();

    @Query(value = "select sum(amount) from tb_transaction join tb_category on tb_transaction.category_id=tb_category.id where tb_category.name='Utilities'", nativeQuery = true)
    BigDecimal sumByAmountWhereUtilities();
}
