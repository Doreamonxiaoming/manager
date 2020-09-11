package com.training.manager.dao;

import com.training.manager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//使用JPA操作数据库的方法可以参考这篇博客：
//  https://blog.csdn.net/pengjunlee/article/details/80038677?utm_medium=distribute.pc_relevant.none-task-blog-title-1&spm=1001.2101.3001.4242
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
