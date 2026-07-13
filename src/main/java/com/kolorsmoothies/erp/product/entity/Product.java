package com.kolorsmoothies.erp.product.entity;

import java.math.BigDecimal;

import com.kolorsmoothies.erp.category.entity.Category;
import com.kolorsmoothies.erp.common.entity.BaseEntity;
import com.kolorsmoothies.erp.enums.RecordStatus;
import com.kolorsmoothies.erp.enums.Unit;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable =false, unique = true, length = 50)
    private String sku;

    @Column(unique = true, length = 50)
    private String barcode;

    @Column(length = 1000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Unit unit;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal purchasePrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal sellingPrice;

    @Column(precision = 5, scale = 2)
    private BigDecimal taxPercentage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecordStatus status;
}
