package com.kolorsmoothies.erp.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LoginResponse {

    private String token;

    private String tokenType;

    private Long userId;

    private String firstName;

    private String lastName;

    private String email;

    private String role;

}