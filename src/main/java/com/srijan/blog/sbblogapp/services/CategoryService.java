package com.srijan.blog.sbblogapp.services;

import com.srijan.blog.sbblogapp.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    // POST - Create
    CategoryDto createCategory(CategoryDto categoryDto);

    // PUT - Update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // DELETE - Delete
    void deleteCategory(Integer categoryId);

    // GET - Get All
    List<CategoryDto> getAllCategories();

    // GET - Get By Id
    CategoryDto getCategoryById(Integer categoryId);

}
