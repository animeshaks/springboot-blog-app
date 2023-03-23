package com.srijan.blog.sbblogapp.controllers;

import com.srijan.blog.sbblogapp.payloads.ApiResponse;
import com.srijan.blog.sbblogapp.payloads.CategoryDto;
import com.srijan.blog.sbblogapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // CREATE
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully!!", true), HttpStatus.OK);
    }

    // GET BY ID
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId){
        CategoryDto categoryDto = this.categoryService.getCategoryById(categoryId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

    // GET ALL
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categoryDtos = this.categoryService.getAllCategories();
        return ResponseEntity.ok(categoryDtos);
    }

}
