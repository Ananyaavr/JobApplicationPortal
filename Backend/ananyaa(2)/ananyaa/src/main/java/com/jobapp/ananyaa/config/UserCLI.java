package com.jobapp.ananyaa.config;

import static com.jobapp.ananyaa.enumerated.Role.ADMIN;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jobapp.ananyaa.model.User;
import com.jobapp.ananyaa.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@SuppressWarnings("null")
public class UserCLI implements CommandLineRunner{
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'run'");
        if(userRepository.count()>0)
        {
            return;
        }
        var user = User.builder()
                 .name("Admin")
                 .email("ananyaavr@gmail.com")
                 .password(passwordEncoder.encode("Admin@123"))
                 .role(ADMIN)
                 .build();
        userRepository.save(user);
    }

}
