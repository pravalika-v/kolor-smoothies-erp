package com.kolorsmoothies.erp.auth.controller;

import com.kolorsmoothies.erp.auth.dto.LoginResponse;
import com.kolorsmoothies.erp.auth.dto.LoginRequest;
import com.kolorsmoothies.erp.auth.dto.RegisterRequest;
import com.kolorsmoothies.erp.auth.service.AuthService;
import com.kolorsmoothies.erp.common.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<LoginResponse> register(
            @Valid @RequestBody RegisterRequest request) {

    	LoginResponse response = authService.register(request);

        return ApiResponse.<LoginResponse>builder()
                .success(true)
                .status(HttpStatus.CREATED.value())
                .message("User registered successfully")
                .data(response)
                .build();
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(
            @Valid @RequestBody LoginRequest request) {
    	//  System.out.println("===== LOGIN API HIT =====");

    	LoginResponse response = authService.login(request);

        return ApiResponse.<LoginResponse>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Login successful")
                .data(response)
                .build();
    }
    
    @GetMapping("/me")
    public ApiResponse<String> me(Authentication authentication) {
        return ApiResponse.success(authentication.getName());
    }

}