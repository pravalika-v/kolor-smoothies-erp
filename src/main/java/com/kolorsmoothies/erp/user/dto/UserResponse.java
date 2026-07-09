package com.kolorsmoothies.erp.user.dto;

import java.time.LocalDateTime;

import com.kolorsmoothies.erp.enums.Role;
import com.kolorsmoothies.erp.enums.UserStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private Role role;

    private UserStatus status;

    private LocalDateTime createdAt;
}