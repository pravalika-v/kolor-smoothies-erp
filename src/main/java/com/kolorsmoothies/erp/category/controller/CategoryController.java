package com.kolorsmoothies.erp.category.controller;

import com.kolorsmoothies.erp.category.dto.CategoryRequest;
import com.kolorsmoothies.erp.category.dto.CategoryResponse;
import com.kolorsmoothies.erp.category.service.CategoryService;
import com.kolorsmoothies.erp.common.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // ==========================================
    // Create Category
    // ==========================================

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<CategoryResponse> createCategory(
            @Valid @RequestBody CategoryRequest request) {

        return ApiResponse.success(
                "Category created successfully",
                categoryService.createCategory(request));
    }

    // ==========================================
    // Get Category By Id
    // ==========================================

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<CategoryResponse> getCategoryById(
            @PathVariable Long id) {

        return ApiResponse.success(
                "Category fetched successfully",
                categoryService.getCategoryById(id));
    }

    // ==========================================
    // Get All Categories
    // ==========================================

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<Page<CategoryResponse>> getAllCategories(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "10") int size) {

        return ApiResponse.success(
                "Categories fetched successfully",
                categoryService.getAllCategories(page, size));
    }

    // ==========================================
    // Search Categories
    // ==========================================

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<Page<CategoryResponse>> searchCategories(

            @RequestParam String keyword,

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "10") int size) {

        return ApiResponse.success(
                "Categories fetched successfully",
                categoryService.searchCategories(
                        keyword,
                        page,
                        size));
    }

    // ==========================================
    // Update Category
    // ==========================================

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<CategoryResponse> updateCategory(

            @PathVariable Long id,

            @Valid @RequestBody CategoryRequest request) {

        return ApiResponse.success(
                "Category updated successfully",
                categoryService.updateCategory(id, request));
    }

    // ==========================================
    // Soft Delete Category
    // ==========================================

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Void> deleteCategory(
            @PathVariable Long id) {

        categoryService.deleteCategory(id);

        return ApiResponse.success(
                "Category deleted successfully",
                null);
    }

}