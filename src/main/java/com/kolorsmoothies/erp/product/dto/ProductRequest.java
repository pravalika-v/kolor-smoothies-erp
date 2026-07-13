package com.kolorsmoothies.erp.product.dto;

import java.math.BigDecimal;

import com.kolorsmoothies.erp.enums.Unit;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String sku;

    private String barcode;

    private String description;

    @NotNull
    private Long categoryId;

    @NotNull
    private Unit unit;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal purchasePrice;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal sellingPrice;

    @DecimalMin("0.00")
    private BigDecimal taxPercentage;
}
