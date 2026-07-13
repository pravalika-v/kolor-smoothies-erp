package com.kolorsmoothies.erp.user.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kolorsmoothies.erp.common.response.ApiResponse;
import com.kolorsmoothies.erp.user.dto.ChangePasswordRequest;
import com.kolorsmoothies.erp.user.dto.ResetPasswordRequest;
import com.kolorsmoothies.erp.user.dto.UpdateUserRequest;
import com.kolorsmoothies.erp.user.dto.UserRequest;
import com.kolorsmoothies.erp.user.dto.UserResponse;
import com.kolorsmoothies.erp.user.service.UserService;
import static com.kolorsmoothies.erp.constant.Permissions.*;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // ============================================
    // Create User
    // ============================================

    @PostMapping
    @PreAuthorize(ADMIN)
    public ApiResponse<UserResponse> createUser(
            @Valid @RequestBody UserRequest request) {

        return ApiResponse.success(
                "User created successfully",
                userService.createUser(request));
    }

    // ============================================
    // Get User By Id
    // ============================================

    @GetMapping("/{id}")
    @PreAuthorize(ADMIN)
    public ApiResponse<UserResponse> getUserById(
            @PathVariable Long id) {

        return ApiResponse.success(
                "User fetched successfully",
                userService.getUserById(id));
    }

    // ============================================
    // Current Logged-in User
    // ============================================

    @GetMapping("/me")
    public ApiResponse<UserResponse> getCurrentUser() {

        return ApiResponse.success(
                "Current user fetched successfully",
                userService.getCurrentUser());
    }

    // ============================================
    // Get All Users
    // ============================================

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Page<UserResponse>> getAllUsers(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "10") int size) {

        return ApiResponse.success(
                "Users fetched successfully",
                userService.getAllUsers(page, size));
    }
    
    

    // ============================================
    // Search Users
    // ============================================

    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Page<UserResponse>> searchUsers(

            @RequestParam String keyword,

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "10") int size) {

        return ApiResponse.success(
                "Users fetched successfully",
                userService.searchUsers(keyword, page, size));
    }

    // ============================================
    // Update User
    // ============================================

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<UserResponse> updateUser(

            @PathVariable Long id,

            @Valid @RequestBody UpdateUserRequest request) {

        return ApiResponse.success(
                "User updated successfully",
                userService.updateUser(id, request));
    }

    // ============================================
    // Delete User (Soft Delete)
    // ============================================

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Void> deleteUser(
            @PathVariable Long id) {

        userService.deleteUser(id);

        return ApiResponse.success(
                "User deleted successfully",
                null);
    }

    // ============================================
    // Change Password
    // ============================================

    @PutMapping("/change-password")
    public ApiResponse<Void> changePassword(

            @Valid @RequestBody ChangePasswordRequest request) {

        userService.changePassword(request);

        return ApiResponse.success(
                "Password changed successfully",
                null);
    }

    // ============================================
    // Reset Password
    // ============================================

    @PutMapping("/{id}/reset-password")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Void> resetPassword(

            @PathVariable Long id,

            @Valid @RequestBody ResetPasswordRequest request) {

        userService.resetPassword(id, request);

        return ApiResponse.success(
                "Password reset successfully",
                null);
    }
    
    @PutMapping("/{id}/activate")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Void> activateUser(@PathVariable Long id) {

        userService.activateUser(id);

        return ApiResponse.success("User activated successfully", null);
    }
    
    @PutMapping("/{id}/deactivate")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Void> deactivateUser(@PathVariable Long id) {

        userService.deactivateUser(id);

        return ApiResponse.success("User deactivated successfully", null);
    }
    
    @PutMapping("/{id}/unlock")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Void> unlockUser(@PathVariable Long id) {

        userService.unlockUser(id);

        return ApiResponse.success("User unlocked successfully", null);
    }
    
    

}