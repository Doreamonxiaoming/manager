package com.training.manager.pojo;


import com.training.manager.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCategory {

    private String name;
    private Date transactTime;
    private BigDecimal amount;
    private String detail;

    private NewCategory category;

}
