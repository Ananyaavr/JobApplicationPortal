package com.jobapp.ananyaa.dto.response;

// import java.util.List;
// import java.util.Collections; 

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.jobapp.ananyaa.model.JobList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobListResponse {
    private String message;
    private String id;
    private String job_title;
    private JobList data;
    private String job_description;
    private String job_location;
    private String salary;
}
