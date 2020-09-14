package com.training.manager.dao;

import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @Test
    public void testCategoryRepository(){
        Category categoryCreate = new Category("create", new BigDecimal(400));
        Category categoryUpdate = new Category(3,"update", new BigDecimal(300));

        categoryRepository.findById(1).get();//通过id查询
        categoryRepository.findAll();//查询所有
        categoryRepository.save(categoryCreate);//save没有id的对象是创建记录
        categoryRepository.save(categoryUpdate);//save有id的对象是更新记录
//        categoryRepository.deleteById(2);//根据id删除记录//如果没有对应id会报错哦
        System.out.println(categoryRepository.count());//查询所有记录条数
        System.out.println(categoryRepository.existsById(3));//判断id对应的记录是否存在
    }

    @Test
    public void testTransactionRepository(){
        Transaction transaction = new Transaction("test",new Date(),new BigDecimal(100),"detail");
        Category category = categoryRepository.findById(1).get();
        Transaction transactionExist = transactionRepository.findById(1).get();
        System.out.println(categoryRepository.findById(1).get());
    }
}