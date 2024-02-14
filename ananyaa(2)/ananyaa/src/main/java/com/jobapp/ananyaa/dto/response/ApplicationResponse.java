package com.jobapp.ananyaa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationResponse {

    private String applicationId;
    private String applicantName;
    private String applicantContact;
    private String workExperience;
    private String applicantEmail;
    private String applicantSkills;
    private String resumePath;
    private String message;
}
    

