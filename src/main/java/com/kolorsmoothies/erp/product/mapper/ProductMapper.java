package com.kolorsmoothies.erp.product.mapper;

import org.springframework.stereotype.Component;

import com.kolorsmoothies.erp.product.dto.ProductRequest;
import com.kolorsmoothies.erp.product.dto.ProductResponse;
import com.kolorsmoothies.erp.product.entity.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {

        return Product.builder()
                .name(request.getName().trim())
                .sku(request.getSku().trim())
                .barcode(request.getBarcode())
                .description(request.getDescription())
                .unit(request.getUnit())
                .purchasePrice(request.getPurchasePrice())
                .sellingPrice(request.getSellingPrice())
                .taxPercentage(request.getTaxPercentage())
                .build();
    }

    public ProductResponse toResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .sku(product.getSku())
                .barcode(product.getBarcode())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .unit(product.getUnit())
                .purchasePrice(product.getPurchasePrice())
                .sellingPrice(product.getSellingPrice())
                .taxPercentage(product.getTaxPercentage())
                .status(product.getStatus())
                .build();
    }

    public void updateEntity(
            Product product,
            ProductRequest request) {

        product.setName(request.getName().trim());
        product.setSku(request.getSku().trim());
        product.setBarcode(request.getBarcode());
        product.setDescription(request.getDescription());
        product.setUnit(request.getUnit());
        product.setPurchasePrice(request.getPurchasePrice());
        product.setSellingPrice(request.getSellingPrice());
        product.setTaxPercentage(request.getTaxPercentage());
    }
}