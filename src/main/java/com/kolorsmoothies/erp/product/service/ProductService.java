package com.kolorsmoothies.erp.product.service;

import org.springframework.data.domain.Page;

import com.kolorsmoothies.erp.product.dto.ProductRequest;
import com.kolorsmoothies.erp.product.dto.ProductResponse;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    ProductResponse updateProduct(
            Long id,
            ProductRequest request);

    ProductResponse getProductById(Long id);

    Page<ProductResponse> getAllProducts(
            int page,
            int size);

    Page<ProductResponse> searchProducts(
            String keyword,
            int page,
            int size);

    void deleteProduct(Long id);
}