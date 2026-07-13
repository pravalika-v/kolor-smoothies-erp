package com.kolorsmoothies.erp.auth.dto;

import com.kolorsmoothies.erp.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank
    private String firstName;

    private String lastName;

    @Email
    @NotBlank
    private String email;

    private String phone;

    @NotBlank
    private String password;

    @NotNull
    private Role role;

}