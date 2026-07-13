package com.kolorsmoothies.erp.supplier.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kolorsmoothies.erp.enums.RecordStatus;
import com.kolorsmoothies.erp.exception.BadRequestException;
import com.kolorsmoothies.erp.exception.ResourceNotFoundException;
import com.kolorsmoothies.erp.supplier.dto.SupplierRequest;
import com.kolorsmoothies.erp.supplier.dto.SupplierResponse;
import com.kolorsmoothies.erp.supplier.entity.Supplier;
import com.kolorsmoothies.erp.supplier.mapper.SupplierMapper;
import com.kolorsmoothies.erp.supplier.repository.SupplierRepository;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    private final SupplierMapper supplierMapper;

    @Override
    public SupplierResponse createSupplier(
            SupplierRequest request) {

        if (supplierRepository.existsByNameIgnoreCase(request.getName())) {

            throw new BadRequestException(
                    "Supplier already exists.");
        }

        if (request.getEmail() != null && !request.getEmail().isBlank()) {

            supplierRepository.findByEmailIgnoreCase(request.getEmail())
                    .ifPresent(existing -> {
                        throw new BadRequestException("Email already exists.");
                    });
        }

        Supplier supplier = supplierMapper.toEntity(request);

        supplier.setSupplierCode(generateSupplierCode());

        supplier.setStatus(RecordStatus.ACTIVE);

        return supplierMapper.toResponse(
                supplierRepository.save(supplier));
    }

    @Override
    public SupplierResponse updateSupplier(
            Long id,
            SupplierRequest request) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Supplier not found"));

        supplierRepository.findByNameIgnoreCase(request.getName())
                .ifPresent(existing -> {

                    if (!existing.getId().equals(id)) {

                        throw new BadRequestException(
                                "Supplier name already exists.");
                    }
                });

        if (request.getEmail() != null &&
                !request.getEmail().isBlank()) {

            supplierRepository.findByEmailIgnoreCase(request.getEmail())
                    .ifPresent(existing -> {

                        if (!existing.getId().equals(id)) {

                            throw new BadRequestException(
                                    "Email already exists.");
                        }
                    });
        }

        supplierMapper.updateEntity(supplier, request);

        return supplierMapper.toResponse(
                supplierRepository.save(supplier));
    }

    @Override
    public SupplierResponse getSupplierById(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Supplier not found"));

        return supplierMapper.toResponse(supplier);
    }

    @Override
    public Page<SupplierResponse> getAllSuppliers(
            int page,
            int size) {

        return supplierRepository
                .findByStatus(
                        RecordStatus.ACTIVE,
                        PageRequest.of(page, size))
                .map(supplierMapper::toResponse);
    }

    @Override
    public Page<SupplierResponse> searchSuppliers(
            String keyword,
            int page,
            int size) {

        return supplierRepository
                .findByStatusAndNameContainingIgnoreCase(
                        RecordStatus.ACTIVE,
                        keyword,
                        PageRequest.of(page, size))
                .map(supplierMapper::toResponse);
    }

    @Override
    public void deleteSupplier(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Supplier not found"));

        supplier.setStatus(RecordStatus.INACTIVE);

        supplierRepository.save(supplier);
    }

    private String generateSupplierCode() {

        return supplierRepository.findTopByOrderByIdDesc()
                .map(supplier ->
                        String.format(
                                "SUP%04d",
                                supplier.getId() + 1))
                .orElse("SUP0001");
    }
}