package com.kolorsmoothies.erp.product.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kolorsmoothies.erp.enums.RecordStatus;
import com.kolorsmoothies.erp.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

boolean existsBySkuIgnoreCase(String sku);

boolean existsByBarcode(String barcode);

Optional<Product> findBySkuIgnoreCase(String sku);

Page<Product> findByStatus(
    RecordStatus status,
    Pageable pageable);

Page<Product> findByStatusAndNameContainingIgnoreCase(
    RecordStatus status,
    String keyword,
    Pageable pageable);
}