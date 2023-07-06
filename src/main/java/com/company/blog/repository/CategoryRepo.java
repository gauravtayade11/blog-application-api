package com.company.blog.repository;

import com.company.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {


//    List<Category> findAll();
}
