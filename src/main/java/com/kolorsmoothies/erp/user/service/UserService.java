package com.kolorsmoothies.erp.user.service;

import java.util.List;

import com.kolorsmoothies.erp.user.dto.UserRequest;
import com.kolorsmoothies.erp.user.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest request);

    UserResponse getUser(Long id);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(Long id, UserRequest request);

    void deleteUser(Long id);

}