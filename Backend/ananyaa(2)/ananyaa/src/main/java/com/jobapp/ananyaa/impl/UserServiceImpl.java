package com.jobapp.ananyaa.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jobapp.ananyaa.dto.response.BasicResponse;
import com.jobapp.ananyaa.dto.response.UserResponse;
import com.jobapp.ananyaa.model.User;
import com.jobapp.ananyaa.repository.UserRepository;
import com.jobapp.ananyaa.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public BasicResponse<UserResponse> getAllUser(){
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream().map(user-> UserResponse.builder()
                      .id(user.getId())
                      .name(user.getName())
                      .email(user.getEmail())
                      .role(user.getRole())
                      .image(user.getImage())
                      .Address(user.getAddress())
                      .PhoneNumber(user.getPhoneNumber())
                      .build())
                      .collect(Collectors.toList());
                      return BasicResponse.<UserResponse>builder()
                               .message("User data fetched Successfully!")
                               .data(userResponses)
                               .build();
        // throw new UnsupportedOperationException("Unimplemented method 'getAllUser'");
    }

}
