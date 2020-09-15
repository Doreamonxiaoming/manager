package com.training.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private Date transactTime;
    private BigDecimal amount;
    private String detail;

    @JsonIgnore
    @ManyToOne(targetEntity=Category.class,fetch=FetchType.LAZY)
    @JoinColumn(name="category_id",referencedColumnName="id")
    private Category category;

    public Transaction(Integer id, String name, Date transactTime, BigDecimal amount, String detail) {
        this.id = id;
        this.name = name;
        this.transactTime = transactTime;
        this.amount = amount;
        this.detail = detail;
    }
}
