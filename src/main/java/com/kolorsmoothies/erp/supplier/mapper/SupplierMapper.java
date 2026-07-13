package com.kolorsmoothies.erp.supplier.mapper;

import org.springframework.stereotype.Component;

import com.kolorsmoothies.erp.supplier.dto.SupplierRequest;
import com.kolorsmoothies.erp.supplier.dto.SupplierResponse;
import com.kolorsmoothies.erp.supplier.entity.Supplier;

@Component
public class SupplierMapper {

    public Supplier toEntity(SupplierRequest request) {

        return Supplier.builder()
                .name(request.getName().trim())
                .contactPerson(request.getContactPerson())
                .mobile(request.getMobile())
                .email(request.getEmail())
                .gstNumber(request.getGstNumber())
                .panNumber(request.getPanNumber())
                .addressLine1(request.getAddressLine1())
                .addressLine2(request.getAddressLine2())
                .city(request.getCity())
                .state(request.getState())
                .pincode(request.getPincode())
                .country(request.getCountry())
                .build();
    }

    public SupplierResponse toResponse(Supplier supplier) {

        return SupplierResponse.builder()
                .id(supplier.getId())
                .supplierCode(supplier.getSupplierCode())
                .name(supplier.getName())
                .contactPerson(supplier.getContactPerson())
                .mobile(supplier.getMobile())
                .email(supplier.getEmail())
                .gstNumber(supplier.getGstNumber())
                .panNumber(supplier.getPanNumber())
                .addressLine1(supplier.getAddressLine1())
                .addressLine2(supplier.getAddressLine2())
                .city(supplier.getCity())
                .state(supplier.getState())
                .pincode(supplier.getPincode())
                .country(supplier.getCountry())
                .status(supplier.getStatus().name())
                .build();
    }

    public void updateEntity(
            Supplier supplier,
            SupplierRequest request) {

        supplier.setName(request.getName().trim());
        supplier.setContactPerson(request.getContactPerson());
        supplier.setMobile(request.getMobile());
        supplier.setEmail(request.getEmail());
        supplier.setGstNumber(request.getGstNumber());
        supplier.setPanNumber(request.getPanNumber());
        supplier.setAddressLine1(request.getAddressLine1());
        supplier.setAddressLine2(request.getAddressLine2());
        supplier.setCity(request.getCity());
        supplier.setState(request.getState());
        supplier.setPincode(request.getPincode());
        supplier.setCountry(request.getCountry());
    }
}