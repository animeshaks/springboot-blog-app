package com.srijan.blog.sbblogapp.services.impl;

import com.srijan.blog.sbblogapp.entities.Category;
import com.srijan.blog.sbblogapp.exceptions.ResourceNotFoundException;
import com.srijan.blog.sbblogapp.payloads.CategoryDto;
import com.srijan.blog.sbblogapp.repositories.CategoryRepository;
import com.srijan.blog.sbblogapp.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category savedCategory = this.categoryRepository.save(category);
        return this.modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updatedCategory = this.categoryRepository.save(category);

        return this.modelMapper.map(updatedCategory, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
        this.categoryRepository.delete(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
        return this.modelMapper.map(category, CategoryDto.class);
    }
}
