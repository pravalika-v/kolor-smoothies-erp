package com.kolorsmoothies.erp.user.mapper;

import com.kolorsmoothies.erp.enums.UserStatus;
import com.kolorsmoothies.erp.user.dto.UserRequest;
import com.kolorsmoothies.erp.user.dto.UserResponse;
import com.kolorsmoothies.erp.user.entity.User;

public class UserMapper {

    private UserMapper() {
    }

    public static User toEntity(UserRequest request) {

        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .role(request.getRole())
                .status(UserStatus.ACTIVE)
                .build();
    }

    public static UserResponse toResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole())
                .status(user.getStatus())
                .createdAt(user.getCreatedAt())
                .build();
    }

}