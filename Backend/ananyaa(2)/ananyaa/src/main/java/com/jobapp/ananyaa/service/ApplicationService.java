package com.jobapp.ananyaa.service;

import com.jobapp.ananyaa.dto.request.ApplicationRequest;
import com.jobapp.ananyaa.dto.response.ApplicationResponse;
import com.jobapp.ananyaa.dto.response.BasicResponse;
// import com.jobapp.ananyaa.dto.response.RegisterResponse;
import com.jobapp.ananyaa.dto.response.RegisterResponse;

public interface ApplicationService {

    BasicResponse<ApplicationResponse> getAllApplications();
    ApplicationResponse createApp(ApplicationRequest request);
    RegisterResponse deleteApp(String applicationId);
    
}
