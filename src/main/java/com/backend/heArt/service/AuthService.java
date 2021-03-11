package com.backend.heArt.service;

import com.backend.heArt.entity.About;
import com.backend.heArt.entity.User;
import com.backend.heArt.repository.UserRepository;
import com.backend.heArt.request.LoginRequest;
import com.backend.heArt.request.SignUpRequest;
import com.backend.heArt.response.ApiResponse;
import com.backend.heArt.response.JwtAuthenticationResponse;
import com.backend.heArt.utilities.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider tokenProvider;

    public ApiResponse registerUser(SignUpRequest signUpRequest, String token) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ApiResponse(false, "Username is already taken!");
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ApiResponse(false, "Email Address already in use!");
        }

        if(userRepository.existsByPhone(signUpRequest.getPhone())) {
            return new ApiResponse(false, "Phone number already in use!");
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPhone(), signUpRequest.getPassword(), signUpRequest.getRole(), false, token);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        About about = new About();
        user.setAbout(about);
        userRepository.save(user);

        return new ApiResponse(true, "Please confirm your registration");
    }

    public JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return new JwtAuthenticationResponse(jwt);
    }

    public ApiResponse confirmUser(String token) {
        System.out.println("Checking for user");
        if(userRepository.existsByConfirmationToken(token)) {
            System.out.println("User found");
            userRepository.setUserEnabled(true, token);
            return new ApiResponse(true, "User registered successfully");
        } else {
            return new ApiResponse(false, "Please give a valid confirmation token");
        }
    }

}
