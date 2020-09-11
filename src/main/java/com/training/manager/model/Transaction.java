package com.training.manager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_transaction")
public class Transaction {
    @Id
    private Integer id;

    @Column
    private String name;
    @Column
    private Category category;
    @Column
    private Date transactTime;
    @Column
    private BigDecimal amount;
    @Column
    private String detail;
}
