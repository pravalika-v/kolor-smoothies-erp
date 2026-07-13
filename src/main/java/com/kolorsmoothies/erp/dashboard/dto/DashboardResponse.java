package com.kolorsmoothies.erp.dashboard.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private Long totalSales;

    private Long todaySales;

    private Long totalCustomers;

    private Long totalSuppliers;

    private Long totalProducts;

    private Long inventoryValue;

    private Long lowStockItems;

    private Long purchaseOrders;

}
