package com.kolorsmoothies.erp.category.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kolorsmoothies.erp.category.entity.Category;
import com.kolorsmoothies.erp.enums.CategoryStatus;

public interface CategoryRepository
        extends JpaRepository<Category, Long> {

    boolean existsByNameIgnoreCase(String name);

    Optional<Category> findByNameIgnoreCase(String name);
    
    Page<Category> findByStatusAndNameContainingIgnoreCase(
            CategoryStatus status,
            String keyword,
            Pageable pageable);
    
    Page<Category> findByStatus(
    		CategoryStatus status,
            Pageable pageable);

}