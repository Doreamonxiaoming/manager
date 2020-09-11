package com.training.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(targetEntity=Category.class,fetch=FetchType.LAZY)
    @JoinColumn(name="category_id",referencedColumnName="id")
    @JsonIgnore
    private Category category;

    @Column
    private Date transactTime;
    private BigDecimal amount;
    private String detail;

    //@Data 这个注解会自动注入get/set方法，不用再添加o^_^
    //@AllArgsConstructor @NoArgsConstructor 这两个注解会自动注入全参和无参构造方法
}
