package com.jobapp.ananyaa.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class JobListRequest
{
    private String id;
    private String job_title;
    private String job_description;
    private String job_location;
    private String salary;
}

    
