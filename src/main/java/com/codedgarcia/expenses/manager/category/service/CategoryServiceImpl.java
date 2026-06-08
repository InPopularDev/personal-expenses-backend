package com.codedgarcia.expenses.manager.category.service;

import com.codedgarcia.expenses.manager.category.dto.CategoryResponse;
import com.codedgarcia.expenses.manager.category.dto.CreateCategoryRequest;
import com.codedgarcia.expenses.manager.category.dto.UpdateCategoryRequest;
import com.codedgarcia.expenses.manager.category.entity.Category;
import com.codedgarcia.expenses.manager.category.entity.Type;
import com.codedgarcia.expenses.manager.category.mapper.CategoryMapper;
import com.codedgarcia.expenses.manager.category.repository.CategoryRepository;
import com.codedgarcia.expenses.manager.user.entity.User;
import com.codedgarcia.expenses.manager.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public CategoryResponse createCategory(
            Long userId,
            CreateCategoryRequest request) {

        if (categoryRepository.existsByUserIdAndNameIgnoreCase(
                userId,
                request.name())) {

            throw new IllegalArgumentException(
                    "Category already exists");
        }

        User user = userRepository.findById(userId)
                .orElseThrow();

        Category category = Category.builder()
                .user(user)
                .name(request.name())
                .type(request.type())
                .build();

        Category savedCategory =
                categoryRepository.save(category);

        return categoryMapper.toResponse(savedCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> getAllCategories(Long userId) {

        return categoryRepository.findByUserId(userId)
                .stream()
                .map(categoryMapper::toResponse)
                .toList();

    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> getCategoriesByType(
            Long userId,
            Type type) {

        return categoryRepository
                .findByUserIdAndType(userId, type)
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponse getCategory(
            Long userId,
            Long categoryId) {

        return categoryRepository
                .findByIdAndUserId(categoryId, userId)
                .map(categoryMapper::toResponse)
                .orElseThrow();
    }

    @Override
    public CategoryResponse updateCategory(
            Long userId,
            Long categoryId,
            UpdateCategoryRequest request) {

        Category category = categoryRepository
                .findByIdAndUserId(categoryId, userId)
                .orElseThrow();

        category.setName(request.name());
        category.setType(request.type());

        Category categorySaved = categoryRepository.save(category);

        return categoryMapper.toResponse(categorySaved);
    }

    @Override
    public void deleteCategory(
            Long userId,
            Long categoryId) {

        Category category = categoryRepository
                .findByIdAndUserId(categoryId, userId)
                .orElseThrow();

        categoryRepository.delete(category);
    }
}
