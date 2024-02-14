package com.jobapp.ananyaa.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {
    private String applicantName;
    private String applicantContact;
    private String workExperience;
    private String applicantEmail;
    private String applicantSkills;
    private String resumePath;
    
}
