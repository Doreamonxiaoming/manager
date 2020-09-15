package com.training.manager.dao;

import com.training.manager.model.Category;
import com.training.manager.model.Transaction;
import com.training.manager.service.TransactionService;
import com.training.manager.service.TransactionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @Test
    public void testCategoryRepository(){
        Category categoryCreate = new Category(5,"create", new BigDecimal(400));
        Category categoryUpdate = new Category(3,"update", new BigDecimal(300));

        Category category = categoryRepository.findById(1).get();//通过id查询
        List<Category> categories = categoryRepository.findAll();//查询所有
        Category category1 = categoryRepository.save(categoryCreate);//save没有id的对象是创建记录
        Category category2 = categoryRepository.save(categoryUpdate);//save有id的对象是更新记录

        //根据id删除记录//如果没有对应id会报错哦//category对应的所有transaction会被删除！！！
        //categoryRepository.deleteById(2);//根据id删除记录//如果没有对应id会报错哦

        System.out.println(categoryRepository.count());//查询所有记录条数
        System.out.println(categoryRepository.existsById(3));//判断id对应的记录是否存在
        List<Category> categoryList = categoryRepository.findByName("category0");//根据名称查询
    }

    @Test
    public void testTransactionRepository() throws ParseException {
        //保存一个transaction记录并设置对应的category
        Transaction transaction = new Transaction(1,"test",new Date(),new BigDecimal(100),"detail");
        Category category = categoryRepository.findById(5).get();
        transaction.setCategory(category);
        transactionRepository.save(transaction);


        //查找两段时间之间的transaction
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        transactionRepository.findByTransactTimeBetween(dateFormat.parse("2020-09-12"), dateFormat.parse("2020-09-15"));
        System.out.println();
    }
}