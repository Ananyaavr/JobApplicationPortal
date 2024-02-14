package com.jobapp.ananyaa.controller;
import static com.jobapp.ananyaa.utils.MyConstant.USER;
import static com.jobapp.ananyaa.utils.MyConstant.USERLIST;
// import static com.jobapp.mona.utils.MyConstant.USER;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jobapp.ananyaa.dto.response.BasicResponse;
import com.jobapp.ananyaa.dto.response.UserResponse;
import com.jobapp.ananyaa.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

        private final UserService userService;
    
        @GetMapping(USERLIST)
        public ResponseEntity<BasicResponse<UserResponse>> create() {
            BasicResponse<UserResponse>  response = new BasicResponse<>();
            try {
                response = userService.getAllUser();
                return new ResponseEntity<>(response, OK);//HttpStatus.OK
            } catch (Exception e) {
                response.setMessage("Something went wrong!");
                return new ResponseEntity<>(response, EXPECTATION_FAILED);//HttpStatus.EXPECTATION_FAILED
            }
        }   
}