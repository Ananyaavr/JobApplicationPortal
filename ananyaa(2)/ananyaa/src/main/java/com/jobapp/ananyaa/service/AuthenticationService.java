package com.jobapp.ananyaa.service;

import com.jobapp.ananyaa.dto.request.LoginRequest;
import com.jobapp.ananyaa.dto.request.RegisterRequest;
import com.jobapp.ananyaa.dto.response.LoginResponse;
import com.jobapp.ananyaa.dto.response.RegisterResponse;

public interface AuthenticationService {

    RegisterResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);

}
