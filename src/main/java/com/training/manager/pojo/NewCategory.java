package com.training.manager.pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
public class NewCategory {
    private Integer value;
    private String label;
    private BigDecimal budget;

    public NewCategory(Integer value, String label, BigDecimal budget) {
        this.value = value;
        this.label = label;
        this.budget = null;
    }
}
