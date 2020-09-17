package com.training.manager.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.training.manager.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewCategory {
    private Integer value;
    private String label;
//    private BigDecimal budget;

//    @JsonIgnore
//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private Set<Transaction> transactions = new HashSet<>();

//    public NewCategory(Integer value, String label, BigDecimal budget, Set<Transaction> transactions) {
//        this.value = value;
//        this.label = label;
//        this.budget = null;
//        this.transactions = transactions;
//    }

//    public NewCategory(Integer value, String label, BigDecimal budget) {
//        this.value = value;
//        this.label = label;
//        this.budget = null;
//    }
}
