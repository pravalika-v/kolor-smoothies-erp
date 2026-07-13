package com.kolorsmoothies.erp.product.controller;

import com.kolorsmoothies.erp.common.response.ApiResponse;
import com.kolorsmoothies.erp.product.dto.ProductRequest;
import com.kolorsmoothies.erp.product.dto.ProductResponse;
import com.kolorsmoothies.erp.product.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<ProductResponse> createProduct(
            @Valid @RequestBody ProductRequest request) {

        return ApiResponse.success(
                "Product created successfully",
                productService.createProduct(request));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<ProductResponse> getProductById(
            @PathVariable Long id) {

        return ApiResponse.success(
                "Product fetched successfully",
                productService.getProductById(id));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<Page<ProductResponse>> getAllProducts(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "10") int size) {

        return ApiResponse.success(
                "Products fetched successfully",
                productService.getAllProducts(page, size));
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<Page<ProductResponse>> searchProducts(

            @RequestParam String keyword,

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "10") int size) {

        return ApiResponse.success(
                "Products fetched successfully",
                productService.searchProducts(
                        keyword,
                        page,
                        size));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<ProductResponse> updateProduct(

            @PathVariable Long id,

            @Valid @RequestBody ProductRequest request) {

        return ApiResponse.success(
                "Product updated successfully",
                productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Void> deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);

        return ApiResponse.success(
                "Product deleted successfully",
                null);
    }
}