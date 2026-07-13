package com.kolorsmoothies.erp.supplier.entity;

import com.kolorsmoothies.erp.common.entity.BaseEntity;
import com.kolorsmoothies.erp.enums.RecordStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String supplierCode;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String contactPerson;

    @Column(length = 15)
    private String mobile;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String gstNumber;

    @Column(length = 15)
    private String panNumber;

    @Column(length = 255)
    private String addressLine1;

    @Column(length = 255)
    private String addressLine2;

    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String state;

    @Column(length = 10)
    private String pincode;

    @Column(length = 100)
    private String country;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecordStatus status;
}