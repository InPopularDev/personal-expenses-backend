package com.codedgarcia.expenses.manager.category.controller;

import com.codedgarcia.expenses.manager.category.dto.CategoryResponse;
import com.codedgarcia.expenses.manager.category.dto.CreateCategoryRequest;
import com.codedgarcia.expenses.manager.category.dto.UpdateCategoryRequest;
import com.codedgarcia.expenses.manager.category.entity.Type;
import com.codedgarcia.expenses.manager.category.service.CategoryServiceImpl;
import com.codedgarcia.expenses.manager.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @GetMapping
    public List<CategoryResponse> getAllCategories(@AuthenticationPrincipal User user) {
        return categoryService.getAllCategories(user.getId());
    }

    @PostMapping
    public CategoryResponse addCategory(
            @AuthenticationPrincipal User user,
            @RequestBody CreateCategoryRequest request) {
        return categoryService.createCategory(user.getId(), request);
    }

    @GetMapping
    public List<CategoryResponse> getAllCategoriesByType(
            @AuthenticationPrincipal User user,
            @RequestParam Type type) {
        return categoryService.getCategoriesByType(user.getId(), type);
    }

    @GetMapping
    public CategoryResponse getCategory(
            @AuthenticationPrincipal User user,
            @RequestParam("categoryId") Long categoryId) {
        return categoryService.getCategory(user.getId(), categoryId);
    }

    @PutMapping
    public CategoryResponse updateCategory(
            @AuthenticationPrincipal User user,
            @RequestParam("categoryId") Long categoryId,
            @RequestBody UpdateCategoryRequest request
    ){
        return categoryService.updateCategory(user.getId(), categoryId, request);
    }

    @DeleteMapping
    public void deleteCategory(
            @AuthenticationPrincipal User user,
            @RequestParam("categoryId") Long categoryId) {
        categoryService.deleteCategory(user.getId(), categoryId);
    }

}
