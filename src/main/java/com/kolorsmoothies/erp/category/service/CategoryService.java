package com.kolorsmoothies.erp.category.service;

import org.springframework.data.domain.Page;

import com.kolorsmoothies.erp.category.dto.CategoryRequest;
import com.kolorsmoothies.erp.category.dto.CategoryResponse;

public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest request);

    CategoryResponse updateCategory(
            Long id,
            CategoryRequest request);

    CategoryResponse getCategoryById(Long id);

    Page<CategoryResponse> getAllCategories(
            int page,
            int size);

    Page<CategoryResponse> searchCategories(
            String keyword,
            int page,
            int size);

    void deleteCategory(Long id);

}