package com.kolorsmoothies.erp.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.kolorsmoothies.erp.common.response.ApiResponse;
import com.kolorsmoothies.erp.constant.ApiEndpoints;
import com.kolorsmoothies.erp.user.dto.UserRequest;
import com.kolorsmoothies.erp.user.dto.UserResponse;
import com.kolorsmoothies.erp.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(ApiEndpoints.USERS)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponse> createUser(
            @Valid @RequestBody UserRequest request) {

        return ApiResponse.success(userService.createUser(request));
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUser(@PathVariable Long id) {

        return ApiResponse.success(userService.getUser(id));
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUsers() {

        return ApiResponse.success(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserRequest request) {

        return ApiResponse.success(userService.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return ApiResponse.success("User deleted successfully.");
    }
}