package com.kolorsmoothies.erp.supplier.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kolorsmoothies.erp.enums.RecordStatus;
import com.kolorsmoothies.erp.supplier.entity.Supplier;

public interface SupplierRepository
        extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findTopByOrderByIdDesc();

    Optional<Supplier> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

    Optional<Supplier> findByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCase(String email);

    Page<Supplier> findByStatus(
            RecordStatus status,
            Pageable pageable);

    Page<Supplier> findByStatusAndNameContainingIgnoreCase(
            RecordStatus status,
            String keyword,
            Pageable pageable);
}