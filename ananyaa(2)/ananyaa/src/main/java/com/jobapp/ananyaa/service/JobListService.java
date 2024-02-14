package com.jobapp.ananyaa.service;

import com.jobapp.ananyaa.dto.request.JobListRequest;
import com.jobapp.ananyaa.dto.response.BasicResponse;
import com.jobapp.ananyaa.dto.response.JobListResponse;
// import com.jobapp.ananyaa.dto.response.RegisterResponse;

public interface JobListService {
    BasicResponse<JobListResponse> getAllJobs();
    JobListResponse createJob(JobListRequest request);
    //  RegisterResponse editJob(String jobId, JobListRequest jobRequest);

}
