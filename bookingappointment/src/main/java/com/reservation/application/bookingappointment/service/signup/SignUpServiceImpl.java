package com.reservation.application.bookingappointment.service.signup;

import com.reservation.application.bookingappointment.entity.SignUp;
import com.reservation.application.bookingappointment.repository.SignUpRepo;
import com.reservation.application.bookingappointment.validations.Validations;
import com.reservation.application.bookingappointment.web.dto.SignUpDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    SignUpRepo signUpRepository;
    ModelMapper modelMapper;
    Validations validation;
    @Override
    public SignUpDTO registration(SignUpDTO signUpDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(signUpDTO.getPassword());
        signUpDTO.setPassword(encodedPassword);
        SignUp signUp = modelMapper.map(signUpDTO, SignUp.class);
        boolean result =  validation.isPersonalNumberPresent(signUpDTO.getPersonalNumber());
        if(!result) {
          SignUp user =  signUpRepository.save(signUp);
          SignUpDTO signUpDTOResponse = modelMapper.map(user,SignUpDTO.class);
            return signUpDTOResponse ;
        }
        else {
            throw new RuntimeException("Account already exists");
        }

    }
}
