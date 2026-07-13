package com.kolorsmoothies.erp.product.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kolorsmoothies.erp.category.entity.Category;
import com.kolorsmoothies.erp.category.repository.CategoryRepository;
import com.kolorsmoothies.erp.enums.RecordStatus;
import com.kolorsmoothies.erp.exception.BadRequestException;
import com.kolorsmoothies.erp.exception.ResourceNotFoundException;
import com.kolorsmoothies.erp.product.dto.ProductRequest;
import com.kolorsmoothies.erp.product.dto.ProductResponse;
import com.kolorsmoothies.erp.product.entity.Product;
import com.kolorsmoothies.erp.product.mapper.ProductMapper;
import com.kolorsmoothies.erp.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl
        implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductResponse createProduct(ProductRequest request) {

        if (productRepository.existsBySkuIgnoreCase(request.getSku())) {
            throw new BadRequestException("SKU already exists.");
        }

        if (request.getBarcode() != null
                && !request.getBarcode().isBlank()
                && productRepository.existsByBarcode(request.getBarcode())) {

            throw new BadRequestException(
                    "Barcode already exists.");
        }

        Category category = categoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category not found"));

        Product product = productMapper.toEntity(request);

        product.setCategory(category);
        product.setStatus(RecordStatus.ACTIVE);

        return productMapper.toResponse(
                productRepository.save(product));
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(
            Long id,
            ProductRequest request) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"));

        productRepository.findBySkuIgnoreCase(request.getSku())
                .ifPresent(existing -> {

                    if (!existing.getId().equals(id)) {

                        throw new BadRequestException(
                                "SKU already exists.");
                    }

                });

        Category category = categoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category not found"));

        productMapper.updateEntity(product, request);

        product.setCategory(category);

        return productMapper.toResponse(
                productRepository.save(product));
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"));

        return productMapper.toResponse(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductResponse> getAllProducts(
            int page,
            int size) {

        return productRepository
                .findByStatus(
                        RecordStatus.ACTIVE,
                        PageRequest.of(page, size))
                .map(productMapper::toResponse);
    }

    @Override
    public Page<ProductResponse> searchProducts(
            String keyword,
            int page,
            int size) {

        return productRepository
                .findByStatusAndNameContainingIgnoreCase(
                        RecordStatus.ACTIVE,
                        keyword,
                        PageRequest.of(page, size))
                .map(productMapper::toResponse);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"));

        product.setStatus(RecordStatus.INACTIVE);

        productRepository.save(product);
    }
}