package com.company.blog.controllers;

import com.company.blog.entities.Category;
import com.company.blog.repository.CategoryRepo;
import com.company.blog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable("id") long categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@Valid @RequestBody Category category, @PathVariable("id") Long categoryId){
        return categoryService.upadteCategory(category,categoryId);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable("id")Long categoryId){
        categoryService.deleteCategory(categoryId);
    }
}
