package com.jobapp.ananyaa.service;

import com.jobapp.ananyaa.dto.response.BasicResponse;
import com.jobapp.ananyaa.dto.response.UserResponse;

public interface UserService {

    BasicResponse<UserResponse> getAllUser();

}
