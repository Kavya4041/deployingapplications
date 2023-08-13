package com.reservation.application.bookingappointment.service.appointment;

import com.reservation.application.bookingappointment.entity.Appointment;
import com.reservation.application.bookingappointment.repository.AppointmentRepo;
import com.reservation.application.bookingappointment.validations.Validations;
import com.reservation.application.bookingappointment.web.dto.AppointmentDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepo appointmentRepo;
    private Validations validations;
    private ModelMapper modelMapper;

    @Override
    public AppointmentStatus checkAppointment(AppointmentDTO appointmentDTO)  {
        Appointment appointment = modelMapper.map(appointmentDTO,Appointment.class);
       boolean isAvailable =  validations.isAppointmentAvailable(appointment.getSelectedDate(),appointment.getSelectedTime());
       if(!isAvailable) {
           appointmentRepo.save(appointment);
           return AppointmentStatus.CONFIRMED;
       }
       else{
           return AppointmentStatus.DENIED;
       }
    }
}
