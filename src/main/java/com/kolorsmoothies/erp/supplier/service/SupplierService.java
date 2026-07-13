package com.kolorsmoothies.erp.supplier.service;

import org.springframework.data.domain.Page;

import com.kolorsmoothies.erp.supplier.dto.SupplierRequest;
import com.kolorsmoothies.erp.supplier.dto.SupplierResponse;

public interface SupplierService {

    SupplierResponse createSupplier(SupplierRequest request);

    SupplierResponse updateSupplier(
            Long id,
            SupplierRequest request);

    SupplierResponse getSupplierById(Long id);

    Page<SupplierResponse> getAllSuppliers(
            int page,
            int size);

    Page<SupplierResponse> searchSuppliers(
            String keyword,
            int page,
            int size);

    void deleteSupplier(Long id);
}