package com.backend.heArt.controller;

import com.backend.heArt.request.LoginRequest;
import com.backend.heArt.request.SignUpRequest;
import com.backend.heArt.response.ApiResponse;
import com.backend.heArt.response.JwtAuthenticationResponse;
import com.backend.heArt.security.EmailSender;
import com.backend.heArt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    EmailSender emailSender;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        JwtAuthenticationResponse jwtResponse = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        ApiResponse registerUserResponse = authService.registerUser(signUpRequest);
        if(!registerUserResponse.getSuccess()) {
            return new ResponseEntity(registerUserResponse, HttpStatus.BAD_REQUEST);
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(signUpRequest.getUsername()).toUri();
        return ResponseEntity.created(location).body(registerUserResponse);
    }

    @GetMapping("/mail")
    public void sendMail(@RequestParam String email) throws UnsupportedEncodingException, MessagingException {
        System.out.println(email);
        emailSender.sendEmail(email);
    }

}
