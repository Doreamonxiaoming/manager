package com.training.manager.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private Integer id;
    private String name;
    private Category category;
    private Date transactTime;
    private BigDecimal amount;
    private String detail;
}
