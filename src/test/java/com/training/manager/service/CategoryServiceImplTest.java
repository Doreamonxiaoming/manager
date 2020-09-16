package com.training.manager.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import com.training.manager.dao.CategoryRepository;
import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import com.training.manager.pojo.CategoryResult;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class CategoryServiceImplTest {

    @InjectMocks
    CategoryServiceImpl categoryService;
    @Mock
    CategoryRepository categoryRepository;

    Transaction transaction;
    Category category;
    List<Category> categories;
    @Before
    public void setUp() throws Exception{
        //在单元测试之前，执行Mockito的注解扫描，并注入依赖
        MockitoAnnotations.initMocks(this);

        // mock database result
        transaction = new Transaction().builder().id(1).name("test").amount(new BigDecimal(100)).detail("test").build();
        category = new Category().builder().id(1).name("test").budget(new BigDecimal(100)).transactions(new HashSet<>()).build();
        transaction.setCategory(category);
        category.getTransactions().add(transaction);
        categories = new ArrayList<>();
        categories.add(category);
    }

    @Test
    public void getAllCategory() {
        // mock findAll() action
        Mockito.when(categoryRepository.findAll()).thenReturn(categories);

        // mock except result
        List<CategoryResult> categoryResultList = new ArrayList<>();
        CategoryResult categoryResult = new CategoryResult().builder().id(1).name("test").budget(new BigDecimal(100)).cost(new BigDecimal(100)).build();
        categoryResultList.add(categoryResult);

        //validate
        assertEquals(categoryResultList,categoryService.getAllCategory());
    }

    @Test
    public void getOneCategory() {
        // mock findById() action
        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(category));

        //validate
        assertEquals(category,categoryService.getOneCategory(1));
    }

    @Test
    public void addCategory() {
        categoryService.addCategory(category);
        verify(categoryRepository).save(category);
    }

    @Test
    public void deleteCategory() {
        categoryService.deleteCategory(1);
        verify(categoryRepository).deleteById(1);

    }

    @Test
    public void modifyCategory() {
        // mock findById() action
        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.ofNullable(category));

        // mock except result
        Category newCategory = new Category().builder().id(2).name("new").budget(new BigDecimal(101)).build();
        categoryService.modifyCategory(1, newCategory);

        //validate
        verify(categoryRepository).save(category);
    }

    @Test
    public void totalBudget() {
        // mock findAll() action
        Mockito.when(categoryRepository.findAll()).thenReturn(categories);

        // validate
        assertEquals(new BigDecimal(100), categoryService.totalBudget());

    }

}