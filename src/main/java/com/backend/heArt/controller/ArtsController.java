package com.backend.heArt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ArtsController {

    @GetMapping("/getRandomArts")
    public ResponseEntity<?> generateRandomArts() {
        return ResponseEntity.ok("This is a public API for Random Arts -> but still doesn't open without token");
    }

    @RequestMapping("/")
    public String reDirToRandomArts() {
        return "redirect:/getRandomArts";
    }
}
