package com.kolorsmoothies.erp.category.mapper;

import org.springframework.stereotype.Component;

import com.kolorsmoothies.erp.category.dto.CategoryRequest;
import com.kolorsmoothies.erp.category.dto.CategoryResponse;
import com.kolorsmoothies.erp.category.entity.Category;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequest request) {

        return Category.builder()
                .name(request.getName().trim())
                .description(request.getDescription())
                .build();
    }

    public CategoryResponse toResponse(Category category) {

        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .status(category.getStatus().name())
                .build();
    }

    public void updateEntity(
            Category category,
            CategoryRequest request) {

        category.setName(request.getName().trim());
        category.setDescription(request.getDescription());
    }
}