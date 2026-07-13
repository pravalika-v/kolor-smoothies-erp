package com.kolorsmoothies.erp.supplier.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SupplierResponse {

    private Long id;

    private String supplierCode;

    private String name;

    private String contactPerson;

    private String mobile;

    private String email;

    private String gstNumber;

    private String panNumber;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String pincode;

    private String country;

    private String status;
}