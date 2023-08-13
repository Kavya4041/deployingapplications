package com.medicare.schedular.medicareschedular.service;

import com.medicare.schedular.medicareschedular.dto.ScheduleAppointmentDTO;
import com.medicare.schedular.medicareschedular.entity.ScheduleAppointment;
import com.medicare.schedular.medicareschedular.repo.ScheduleAppointmentRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleAppointmentServiceImpl implements ScheduleAppointmentService {
    private ScheduleAppointmentRepo appointmentRepo;
  //  private Validations validations;
    private ModelMapper modelMapper;




    @Override
    public void checkAppointment(ScheduleAppointmentDTO appointmentDTO) {
        ScheduleAppointment appointment = modelMapper.map(appointmentDTO, ScheduleAppointment.class);
        // boolean isAvailable =  validations.isAppointmentAvailable(appointment.getSelectedDate(),appointment.getSelectedTime());
        /*if(!isAvailable) {
            appointmentRepo.save(appointment);
            return AppointmentStatus.CONFIRMED;
        }
        else{
            return AppointmentStatus.DENIED;
        }*/
    }
}
