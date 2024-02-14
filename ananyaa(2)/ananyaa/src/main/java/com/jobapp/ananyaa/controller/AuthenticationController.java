package com.jobapp.ananyaa.controller;

import static com.jobapp.ananyaa.utils.MyConstant.AUTH;
import static com.jobapp.ananyaa.utils.MyConstant.LOGIN;
import static com.jobapp.ananyaa.utils.MyConstant.REGISTER;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.ananyaa.dto.request.LoginRequest;
import com.jobapp.ananyaa.dto.request.RegisterRequest;
import com.jobapp.ananyaa.dto.response.LoginResponse;
import com.jobapp.ananyaa.dto.response.RegisterResponse;
import com.jobapp.ananyaa.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(REGISTER)//MyConstant.REGISTER then convert it into static
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        RegisterResponse response = new RegisterResponse();
        try{
              response = authenticationService.register(request);
              return new ResponseEntity<>(response, ACCEPTED);
        }
        catch(Exception e){
            response.setMessage("Something went wrong!");
            return new ResponseEntity<>(response, EXPECTATION_FAILED);
        }
    }
    
    //MyConstant.LOGIN
    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request)
    {
        LoginResponse response = new LoginResponse();
        try{
            response = authenticationService.login(request);
            return new ResponseEntity<>(response, ACCEPTED);//HttpStatus.ACCEPTED then convert it into static import

        }
        catch(Exception e)
        {
                    response.setMessage("Something went wrong!");
                    response.setToken("");
            return new ResponseEntity<>(response, EXPECTATION_FAILED);//type HttpStatus.EXPECTATION_FAILED thjen convert it into static
        }
    }

}
