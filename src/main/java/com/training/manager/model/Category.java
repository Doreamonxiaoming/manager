package com.training.manager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private BigDecimal budget;

    //@Data 这个注解会自动注入get/set方法，不用再添加o^_^
    //@AllArgsConstructor @NoArgsConstructor 这两个注解会自动注入全参和无参构造方法
}
