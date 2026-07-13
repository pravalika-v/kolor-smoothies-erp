package com.kolorsmoothies.erp.supplier.controller;

import com.kolorsmoothies.erp.common.response.ApiResponse;
import com.kolorsmoothies.erp.supplier.dto.SupplierRequest;
import com.kolorsmoothies.erp.supplier.dto.SupplierResponse;
import com.kolorsmoothies.erp.supplier.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    // ==========================================
    // Create Supplier
    // ==========================================

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<SupplierResponse> createSupplier(
            @Valid @RequestBody SupplierRequest request) {

        return ApiResponse.success(
                "Supplier created successfully",
                supplierService.createSupplier(request));
    }

    // ==========================================
    // Get Supplier By Id
    // ==========================================

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<SupplierResponse> getSupplierById(
            @PathVariable Long id) {

        return ApiResponse.success(
                "Supplier fetched successfully",
                supplierService.getSupplierById(id));
    }

    // ==========================================
    // Get All Suppliers
    // ==========================================

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<Page<SupplierResponse>> getAllSuppliers(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "10") int size) {

        return ApiResponse.success(
                "Suppliers fetched successfully",
                supplierService.getAllSuppliers(page, size));
    }

    // ==========================================
    // Search Suppliers
    // ==========================================

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<Page<SupplierResponse>> searchSuppliers(

            @RequestParam String keyword,

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "10") int size) {

        return ApiResponse.success(
                "Suppliers fetched successfully",
                supplierService.searchSuppliers(
                        keyword,
                        page,
                        size));
    }

    // ==========================================
    // Update Supplier
    // ==========================================

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','STORE_MANAGER')")
    public ApiResponse<SupplierResponse> updateSupplier(

            @PathVariable Long id,

            @Valid @RequestBody SupplierRequest request) {

        return ApiResponse.success(
                "Supplier updated successfully",
                supplierService.updateSupplier(
                        id,
                        request));
    }

    // ==========================================
    // Delete Supplier
    // ==========================================

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Void> deleteSupplier(
            @PathVariable Long id) {

        supplierService.deleteSupplier(id);

        return ApiResponse.success(
                "Supplier deleted successfully",
                null);
    }
}