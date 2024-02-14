package com.jobapp.ananyaa.controller;

import static com.jobapp.ananyaa.utils.MyConstant.ADDAPP;
import static com.jobapp.ananyaa.utils.MyConstant.DELAPP;
import static com.jobapp.ananyaa.utils.MyConstant.GETAPP;
import static com.jobapp.ananyaa.utils.MyConstant.JOB;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.ananyaa.dto.request.ApplicationRequest;
import com.jobapp.ananyaa.dto.response.ApplicationResponse;
import com.jobapp.ananyaa.dto.response.BasicResponse;
import com.jobapp.ananyaa.dto.response.RegisterResponse;
// import com.jobapp.ananyaa.dto.response.JobListResponse;
// import com.jobapp.ananyaa.dto.response.RegisterResponse;
import com.jobapp.ananyaa.service.ApplicationService;

import lombok.RequiredArgsConstructor;

@RequestMapping(JOB)
@RestController
@RequiredArgsConstructor
public class ApplicationController {
    
    private final  ApplicationService applicationService;
     @GetMapping(GETAPP)
       public ResponseEntity<BasicResponse<ApplicationResponse>> create() {
        BasicResponse<ApplicationResponse> response=new BasicResponse<>();
           try {
               response=applicationService.getAllApplications();
               return new ResponseEntity<>(response,OK);
           } catch (Exception e) {
               response.setMessage("Something went wrong!");
               return new ResponseEntity<>(response, EXPECTATION_FAILED);
           }
       }

    @PostMapping(ADDAPP)
    public ResponseEntity<ApplicationResponse>register(@RequestBody ApplicationRequest request)
    {
        ApplicationResponse response=new ApplicationResponse();
        try{
            response=applicationService.createApp(request);
            return new ResponseEntity<>(response,ACCEPTED);
        }catch (Exception e)
        {
            System.out.println(e);
            response.setMessage("Something went wrong!");
            return new ResponseEntity<>(response,INTERNAL_SERVER_ERROR);
        }
    }  
    
    @DeleteMapping(DELAPP+"/{applicationId}")
    public ResponseEntity<RegisterResponse> deleteApp(@PathVariable String applicationId) {
        RegisterResponse response = applicationService.deleteApp(applicationId);
        if (response.getMessage().equals("Application deleted successfully")) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } else if (response.getMessage().equals("Application not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        }
    }
}
