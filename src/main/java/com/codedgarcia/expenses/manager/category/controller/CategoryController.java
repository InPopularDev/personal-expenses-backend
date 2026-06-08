package com.codedgarcia.expenses.manager.category.controller;

import com.codedgarcia.expenses.manager.category.dto.CategoryResponse;
import com.codedgarcia.expenses.manager.category.dto.CreateCategoryRequest;
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
    public CategoryResponse addCategory(@AuthenticationPrincipal User user, @RequestBody CreateCategoryRequest request) {
        return categoryService.createCategory(user.getId(), request);
    }

}
