package com.training.manager.pojo;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResult {

    private Integer id;
    private String name;

    private Date transactTime;
    private BigDecimal amount;
    private String detail;

    private String categoryName;

}
