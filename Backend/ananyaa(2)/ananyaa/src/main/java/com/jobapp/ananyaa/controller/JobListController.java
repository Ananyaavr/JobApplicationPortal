package com.jobapp.ananyaa.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jobapp.ananyaa.service.JobListService;
// import com.jobapp.ananyaa.utils.MyConstant;

import lombok.RequiredArgsConstructor;

import com.jobapp.ananyaa.dto.request.JobListRequest;
import com.jobapp.ananyaa.dto.response.BasicResponse;
import com.jobapp.ananyaa.dto.response.JobListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobListController {
    private final JobListService jobListService;
    
    @GetMapping("/getAll")
    public ResponseEntity<BasicResponse<JobListResponse>> getAllJobs() {
        BasicResponse<JobListResponse> response = new BasicResponse<>();
        try {
            response = jobListService.getAllJobs();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Something went wrong!");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<JobListResponse> createJob(@RequestBody JobListRequest request) {
        JobListResponse response = new JobListResponse();
        try 
        {
            response = jobListService.createJob(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } 
        catch (Exception e) 
        {
            response.setMessage("Something went wrong!");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
