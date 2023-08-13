package com.reservation.application.bookingappointment.validations;

import com.reservation.application.bookingappointment.repository.AppointmentRepo;
import com.reservation.application.bookingappointment.repository.SignUpRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ValidationImpl implements Validations {
     SignUpRepo signUpRepository;
    AppointmentRepo appointmentRepo;
    public boolean isPersonalNumberPresent(Long personalNumber) {
        long count = signUpRepository.checkPersonalNumber(personalNumber);
        return count > 0;
    }

    @Override
    public boolean isAppointmentAvailable(String selectedDate , String selectedTime) {
       Long count = appointmentRepo.checkAppointmentDateAndTime(selectedDate,selectedTime);

        return count>0;
    }
}
