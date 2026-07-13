package com.kolorsmoothies.erp.auth.service;

import com.kolorsmoothies.erp.auth.dto.LoginResponse;
import com.kolorsmoothies.erp.auth.dto.LoginRequest;
import com.kolorsmoothies.erp.auth.dto.RegisterRequest;

public interface AuthService {

    LoginResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}