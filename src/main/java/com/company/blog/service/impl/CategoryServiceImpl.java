package com.company.blog.service.impl;

import com.company.blog.Exception.ResourceNotFound;
import com.company.blog.entities.Category;
import com.company.blog.repository.CategoryRepo;
import com.company.blog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategory(long categoryId) {
        return categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFound("Category not found with id = "+ categoryId));
    }

    @Override
    public Category createCategory( Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category upadteCategory(Category category, Long categoryId) {
        Category category1 = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFound("Category Not Found with id = " + categoryId));
        if(categoryId != null){
            if(category.getCategoryTitle() != null){
                category1.setCategoryTitle(category.getCategoryTitle());
            }
            if(category.getCategoryDescriptions()!= null){
                category1.setCategoryDescriptions(category.getCategoryDescriptions());
            }
        }
//        else throw new UserNotFound("Category Not Found with id = " + categoryId );
        return categoryRepo.save(category1);

    }

    @Override
//    @ResponseBody()
    public void deleteCategory(Long categoryId) {
//        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFound("Category not found with id = "+ categoryId));
//        categoryRepo.deleteById(categoryId);
        Category category = categoryRepo.findById(categoryId).orElse(null);
        if (category != null){
            categoryRepo.deleteById(categoryId);

        }
        else throw new ResourceNotFound("Category not found with id = "+ categoryId);
    }


}
