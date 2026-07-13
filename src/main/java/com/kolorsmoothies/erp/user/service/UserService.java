package com.kolorsmoothies.erp.user.service;

import org.springframework.data.domain.Page;

import com.kolorsmoothies.erp.user.dto.ChangePasswordRequest;
import com.kolorsmoothies.erp.user.dto.ResetPasswordRequest;
import com.kolorsmoothies.erp.user.dto.UpdateUserRequest;
import com.kolorsmoothies.erp.user.dto.UserRequest;
import com.kolorsmoothies.erp.user.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest request);

    UserResponse getUserById(Long id);

    UserResponse getCurrentUser();

    UserResponse updateUser(Long id, UpdateUserRequest request);

    void deleteUser(Long id);

    Page<UserResponse> getAllUsers(int page, int size);

    Page<UserResponse> searchUsers(String keyword, int page, int size);

    void changePassword(ChangePasswordRequest request);

    void resetPassword(Long id, ResetPasswordRequest request);
    
    void activateUser(Long id);

    void deactivateUser(Long id);

    void lockUser(Long id);

    void unlockUser(Long id);
}