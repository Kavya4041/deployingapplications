package com.reservation.application.bookingappointment.controller;

import com.reservation.application.bookingappointment.service.login.LoginiService;
import com.reservation.application.bookingappointment.web.dto.LoginDTO;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1")
public class LoginController {

    private final LoginiService loginiService;

    @PostMapping("/userlogin")
    public ResponseEntity<HttpStatus> authorize(@RequestBody @NotNull LoginDTO loginDTO) {
        loginiService.loggingIn(loginDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
