package com.kolorsmoothies.erp.product.dto;

import java.math.BigDecimal;

import com.kolorsmoothies.erp.enums.RecordStatus;
import com.kolorsmoothies.erp.enums.Unit;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long id;

    private String name;

    private String sku;

    private String barcode;

    private String description;

    private Long categoryId;

    private String categoryName;

    private Unit unit;

    private BigDecimal purchasePrice;

    private BigDecimal sellingPrice;

    private BigDecimal taxPercentage;

    private RecordStatus status;
}
