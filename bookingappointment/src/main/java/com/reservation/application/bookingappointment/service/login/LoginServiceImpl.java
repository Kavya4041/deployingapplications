package com.reservation.application.bookingappointment.service.login;


import com.reservation.application.bookingappointment.entity.Login;
import com.reservation.application.bookingappointment.repository.LoginRepo;
import com.reservation.application.bookingappointment.validations.Validations;
import com.reservation.application.bookingappointment.web.dto.LoginDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginiService {

   private final LoginRepo loginRepo;
   private final ModelMapper modelMapper;
   private final Validations validation;;
   @Override
    public LoginDTO loggingIn(LoginDTO loginDTO) {
       Login login = modelMapper.map(loginDTO,Login.class);
       boolean result =  validation.isPersonalNumberPresent(login.getPersonalNumber());
       if(result){
         loginRepo.save(login);
         LoginDTO loginDTO1 = modelMapper.map(login,LoginDTO.class);
         return loginDTO1;
       }
       else {
           throw new RuntimeException("Invalid Personal Number");
       }
   }
}
