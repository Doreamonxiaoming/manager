package com.training.manager.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class TransactionRaw {

    private String name;

    private Date transactTime;
    private BigDecimal amount;
    private String detail;

    private String categoryName;

}
