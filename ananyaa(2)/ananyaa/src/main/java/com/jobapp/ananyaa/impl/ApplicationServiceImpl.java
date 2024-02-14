package com.jobapp.ananyaa.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jobapp.ananyaa.dto.request.ApplicationRequest;
import com.jobapp.ananyaa.dto.response.ApplicationResponse;
import com.jobapp.ananyaa.dto.response.BasicResponse;
import com.jobapp.ananyaa.dto.response.RegisterResponse;
// import com.jobapp.ananyaa.dto.response.RegisterResponse;
import com.jobapp.ananyaa.model.Application;
import com.jobapp.ananyaa.repository.ApplicationRepository;
import com.jobapp.ananyaa.service.ApplicationService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService{

    private final ApplicationRepository applicationRepository;
   
    @Override
    public BasicResponse<ApplicationResponse> getAllApplications() {
        List<Application> apps = applicationRepository.findAll();
        List<ApplicationResponse> ApplicationResponses = apps.stream()
    .map(app -> ApplicationResponse.builder().applicationId(app.getApplicationId())
    .applicantName(app.getApplicantName())
    .applicantContact(app.getApplicantContact())
    .applicantEmail(app.getApplicantEmail())
    .applicantSkills(app.getApplicantSkills())
    .resumePath(app.getResumePath())
    .build())
    .collect(Collectors.toList());
        return BasicResponse.<ApplicationResponse>builder()
        .message("Application data fetched successfully!")
          .data(ApplicationResponses)
          .build();
    }
    @Override
    public ApplicationResponse createApp(ApplicationRequest request) {
        var user=Application.builder()
        .applicantName(request.getApplicantName())
        .applicantContact(request.getApplicantContact())
        .workExperience(request.getWorkExperience())
        .applicantEmail(request.getApplicantEmail())
        .applicantSkills(request.getApplicantSkills())
        .resumePath(request.getResumePath())
                .build();
        applicationRepository.save(user);
        return ApplicationResponse.builder()
        .message("Application created successfully!")
        .build();
    }

     @Override
    public RegisterResponse deleteApp(String applicationId) {
    RegisterResponse response = new RegisterResponse();
    try {
        
        Optional<Application> optionalCourse = applicationRepository.findById(applicationId);
        if (optionalCourse.isPresent()) {
            applicationRepository.deleteById(applicationId);
            response.setMessage("Application deleted successfully");
            return response;
        } else {
            response.setMessage("Application not found");
            return response;
        }
    } catch (Exception e) {
        response.setMessage("Something went wrong");
        return response;
    }
}
    
     // @Override
    //     public BasicResponse<GiftResponse> deletegift(String giftId) {
    //         if (giftRepository.existsById(giftId)) {
    //             giftRepository.deleteById(giftId);
    //             return BasicResponse.<GiftResponse>builder()
    //                 .message("Gift deleted successfully")
    //                 .build();
    //         } else {
    //             return BasicResponse.<GiftResponse>builder()
    //                 .message("Gift not found with ID: " + giftId)
    //                 .build();
    //         }
    //     }
}
