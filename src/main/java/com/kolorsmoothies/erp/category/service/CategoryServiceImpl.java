package com.kolorsmoothies.erp.category.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kolorsmoothies.erp.category.dto.CategoryRequest;
import com.kolorsmoothies.erp.category.dto.CategoryResponse;
import com.kolorsmoothies.erp.category.entity.Category;
import com.kolorsmoothies.erp.category.mapper.CategoryMapper;
import com.kolorsmoothies.erp.category.repository.CategoryRepository;
import com.kolorsmoothies.erp.enums.CategoryStatus;
import com.kolorsmoothies.erp.enums.UserStatus;
import com.kolorsmoothies.erp.exception.BadRequestException;
import com.kolorsmoothies.erp.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl
        implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createCategory(
            CategoryRequest request) {

        if (categoryRepository.existsByNameIgnoreCase(request.getName())) {

            throw new BadRequestException(
                    "Category already exists.");
        }

        Category category = categoryMapper.toEntity(request);

        category.setStatus(CategoryStatus.ACTIVE);

        return categoryMapper.toResponse(
                categoryRepository.save(category));
    }

    @Override
    public CategoryResponse updateCategory(
            Long id,
            CategoryRequest request) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category not found"));

        categoryRepository.findByNameIgnoreCase(request.getName())
                .ifPresent(existing -> {

                    if (!existing.getId().equals(id)) {

                        throw new BadRequestException(
                                "Category name already exists.");
                    }

                });

        categoryMapper.updateEntity(category, request);

        return categoryMapper.toResponse(
                categoryRepository.save(category));
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category not found"));

        return categoryMapper.toResponse(category);
    }

    @Override
    public Page<CategoryResponse> getAllCategories(
            int page,
            int size) {
    	return categoryRepository
    	        .findByStatus(
    	        		CategoryStatus.ACTIVE,
    	                PageRequest.of(page, size))
    	        .map(categoryMapper::toResponse);
    }

    @Override
    public Page<CategoryResponse> searchCategories(
            String keyword,
            int page,
            int size) {
    	keyword = keyword.trim();
    	
    	if(keyword.isBlank()){
    	    return getAllCategories(page,size);
    	}

        return categoryRepository
                .findByStatusAndNameContainingIgnoreCase(CategoryStatus.ACTIVE,
                        keyword,
                        PageRequest.of(page, size,Sort.by("name").ascending()))
                .map(categoryMapper::toResponse);
    }

    @Override
    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category not found"));

        category.setStatus(CategoryStatus.INACTIVE);
        
        if(category.getStatus()==CategoryStatus.INACTIVE){
            throw new BadRequestException("Category already deleted.");
        }

        categoryRepository.save(category);
    }

}