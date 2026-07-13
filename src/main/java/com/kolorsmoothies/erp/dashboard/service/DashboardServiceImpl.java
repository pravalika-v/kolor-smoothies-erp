package com.kolorsmoothies.erp.dashboard.service;

import org.springframework.stereotype.Service;

import com.kolorsmoothies.erp.dashboard.dto.DashboardResponse;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Override
    public DashboardResponse getDashboard() {

        return DashboardResponse.builder()
                .totalSales(3250000L)
                .todaySales(58000L)
                .totalCustomers(250L)
                .totalSuppliers(38L)
                .totalProducts(420L)
                .inventoryValue(1250000L)
                .lowStockItems(14L)
                .purchaseOrders(65L)
                .build();
    }
}
