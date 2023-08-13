package com.reservation.application.bookingappointment.controller;

import com.reservation.application.bookingappointment.entity.SignUp;
import com.reservation.application.bookingappointment.service.signup.SignUpService;
import com.reservation.application.bookingappointment.web.dto.SignUpDTO;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class SignUpController {

    private final SignUpService signUpService;

    @PostMapping("/newusers")
    public ResponseEntity<SignUpDTO> authenticate(@RequestBody @NotNull SignUpDTO signUpDTO) {
        SignUpDTO signUpDTO1 = signUpService.registration(signUpDTO);
        return (ResponseEntity) new ResponseEntity<>(HttpStatus.ACCEPTED).getBody();
    }
}
