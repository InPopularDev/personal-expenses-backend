package com.codedgarcia.expenses.manager.category.repository;

import com.codedgarcia.expenses.manager.category.entity.Category;
import com.codedgarcia.expenses.manager.category.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByUserId(Long userId);

    List<Category> findByUserIdAndType(
            Long userId,
            Type type);

    Optional<Category> findByIdAndUserId(
            Long categoryId,
            Long userId);

    boolean existsByUserIdAndNameIgnoreCase(
            Long userId,
            String name);

    Optional<Category> findByUserIdAndName(
            Long userId,
            String name);

}
