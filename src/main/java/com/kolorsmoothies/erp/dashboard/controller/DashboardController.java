package com.kolorsmoothies.erp.dashboard.controller;

import org.springframework.web.bind.annotation.*;

import com.kolorsmoothies.erp.common.response.ApiResponse;
import com.kolorsmoothies.erp.dashboard.dto.DashboardResponse;
import com.kolorsmoothies.erp.dashboard.service.DashboardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public ApiResponse<DashboardResponse> getDashboard() {

        return ApiResponse.success(
                "Dashboard loaded successfully",
                dashboardService.getDashboard());

    }

}