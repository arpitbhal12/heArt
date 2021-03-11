package com.backend.heArt.controller;

import com.backend.heArt.request.LoginRequest;
import com.backend.heArt.request.SignUpRequest;
import com.backend.heArt.response.ApiResponse;
import com.backend.heArt.response.JwtAuthenticationResponse;
import com.backend.heArt.utilities.email.EmailSender;
import com.backend.heArt.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
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
        System.out.println(signUpRequest);
        String token = UUID.randomUUID().toString();
        ApiResponse registerUserResponse = authService.registerUser(signUpRequest, token);
        if(!registerUserResponse.getSuccess()) {
            return new ResponseEntity(registerUserResponse, HttpStatus.BAD_REQUEST);
        }
        try {
            emailSender.sendEmail(signUpRequest, token);
        } catch (MessagingException | UnsupportedEncodingException exception) {
            log.error("An error occurred while sending the email confirmation of successful sign-up");
            log.error(exception.getMessage());
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(signUpRequest.getUsername()).toUri();
        return ResponseEntity.created(location).body(registerUserResponse);
    }

    @GetMapping("/confirm-registration")
    public ResponseEntity<?> confirmUserRegistration(@RequestParam("token") String token) {
        ApiResponse registerUserResponse = authService.confirmUser(token);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}").buildAndExpand(token).toUri();
            return ResponseEntity.created(location).body(registerUserResponse);
    }
}
