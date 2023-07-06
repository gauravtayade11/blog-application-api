package com.company.blog.services;

import com.company.blog.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    Category getCategory(long categoryId);

    Category createCategory(Category category);

    Category upadteCategory(Category category, Long categoryId);

    void deleteCategory(Long categoryId);
}
