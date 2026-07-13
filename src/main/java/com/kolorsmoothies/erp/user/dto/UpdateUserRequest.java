package com.kolorsmoothies.erp.user.dto;

import com.kolorsmoothies.erp.enums.Role;
import com.kolorsmoothies.erp.enums.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserRequest {

    @NotBlank(message = "First name is required")
    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email
    @Size(max = 150)
    private String email;

    @Size(max = 20)
    private String phone;

    @NotNull
    private Role role;

    @NotNull
    private UserStatus status;
}