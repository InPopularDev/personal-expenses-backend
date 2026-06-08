package com.codedgarcia.expenses.manager.category.service;

import com.codedgarcia.expenses.manager.category.dto.CategoryResponse;
import com.codedgarcia.expenses.manager.category.dto.CreateCategoryRequest;
import com.codedgarcia.expenses.manager.category.dto.UpdateCategoryRequest;
import com.codedgarcia.expenses.manager.category.entity.Type;

import java.util.List;

public interface CategoryService {

    CategoryResponse createCategory(
            Long userId,
            CreateCategoryRequest request);

    List<CategoryResponse> getAllCategories(Long userId);

    List<CategoryResponse> getCategoriesByType(Long userId,Type type);

    CategoryResponse getCategory(Long userId, Long categoryId);

    CategoryResponse updateCategory(
            Long userId,
            Long categoryId,
            UpdateCategoryRequest request);

    void deleteCategory(Long userId, Long categoryId);
}
