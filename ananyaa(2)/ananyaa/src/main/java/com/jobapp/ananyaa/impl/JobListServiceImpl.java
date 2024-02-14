package com.jobapp.ananyaa.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.jobapp.ananyaa.model.JobList;
import com.jobapp.ananyaa.repository.JobListRepository;
import com.jobapp.ananyaa.service.JobListService;
import com.jobapp.ananyaa.dto.request.JobListRequest;
import com.jobapp.ananyaa.dto.response.BasicResponse;
import com.jobapp.ananyaa.dto.response.JobListResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobListServiceImpl implements JobListService {
    private final JobListRepository giftRepo;

    @Override
    public BasicResponse<JobListResponse> getAllJobs() 
    {
        List<JobList> gifts = giftRepo.findAll();
        List<JobListResponse> giftResponses = gifts.stream()
            .map(gift -> JobListResponse.builder()
                .id(gift.getId())
                .job_title(gift.getJob_title())
                .job_description(gift.getJob_description())
                .job_location(gift.getJob_location())
                .salary(gift.getSalary())
                .build())
            .collect(Collectors.toList());
        return BasicResponse.<JobListResponse>builder()
            .message("success!")
            .data(giftResponses)
            .build();
    }

    private final JobListRepository giftRepository;
    @Override
    public JobListResponse createJob(JobListRequest request) {
        var gift = JobList.builder()
            .id(request.getId())
            .job_title(request.getJob_title())
            .job_description(request.getJob_description())
            .job_location(request.getJob_location())
            .salary(request.getSalary())
            .build();
        giftRepository.save(gift);
        return JobListResponse.builder()
            .message("Gift created successfully")
            .build();
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
        
    //     @Override
    //     public GiftResponse updateGift(String giftId, GiftRequest request) {
    //         if (giftRepository.existsById(giftId)) {
    //             Gift existingGift = giftRepository.findById(giftId).orElse(null);
    //             if (existingGift != null) {
    //                 existingGift.setGift_name(request.getGift_name());
    //                 existingGift.setGift_price(request.getGift_price());
    //                 existingGift.setGift_image(request.getGift_image());
    //                 existingGift.setGift_rating(request.getGift_rating());
    //                 existingGift.setGift_category(request.getGift_category());
    //                 giftRepository.save(existingGift);
    //                 return GiftResponse.builder()
    //                     .message("Gift updated successfully")
    //                     .build();
    //             } else {
    //                 return GiftResponse.builder()
    //                     .message("Failed to update gift. Gift not found with ID: " + giftId)
    //                     .build();
    //             }
    //         } else {
    //             return GiftResponse.builder()
    //                 .message("Failed to update gift. Gift not found with ID: " + giftId)
    //                 .build();
    //         }
    //     }
        

}