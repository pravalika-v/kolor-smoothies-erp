package com.kolorsmoothies.erp.user.mapper;

import org.springframework.stereotype.Component;

import com.kolorsmoothies.erp.enums.UserStatus;
import com.kolorsmoothies.erp.user.dto.UpdateUserRequest;
import com.kolorsmoothies.erp.user.dto.UserRequest;
import com.kolorsmoothies.erp.user.dto.UserResponse;
import com.kolorsmoothies.erp.user.entity.User;

@Component
public class UserMapper {

    /**
     * Convert Create Request -> Entity
     */
    public User toEntity(UserRequest request) {

        if (request == null) {
            return null;
        }

        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword()) // Service will encode it
                .role(request.getRole())
                .status(UserStatus.ACTIVE)
                .build();
    }

    /**
     * Convert Entity -> Response
     */
    public UserResponse toResponse(User user) {

        if (user == null) {
            return null;
        }

        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole())
                .status(user.getStatus())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    /**
     * Update existing Entity
     */
    public void updateEntity(User user, UpdateUserRequest request) {

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());
        user.setStatus(request.getStatus());
    }

}