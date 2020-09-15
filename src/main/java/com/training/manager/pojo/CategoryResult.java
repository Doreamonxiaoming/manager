package com.training.manager.pojo;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResult {
    private Integer id;
    private String name;
    private BigDecimal budget;
    private BigDecimal cost;
}
