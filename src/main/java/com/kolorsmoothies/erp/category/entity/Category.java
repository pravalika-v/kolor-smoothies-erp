package com.kolorsmoothies.erp.category.entity;

import com.kolorsmoothies.erp.common.entity.BaseEntity;
import com.kolorsmoothies.erp.enums.CategoryStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity {

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryStatus status;

}