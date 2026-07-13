package com.kolorsmoothies.erp.supplier.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierRequest {

    @NotBlank
    private String name;

    private String contactPerson;

    private String mobile;

    @Email
    private String email;

    private String gstNumber;

    private String panNumber;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String pincode;

    private String country;
}