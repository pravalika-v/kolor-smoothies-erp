package com.kolorsmoothies.erp.user.dto;

import com.kolorsmoothies.erp.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "First name is required")
    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    @Size(max = 150)
    private String email;

    @Size(max = 20)
    private String phone;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 100)
    private String password;

    @NotNull(message = "Role is required")
    private Role role;
}