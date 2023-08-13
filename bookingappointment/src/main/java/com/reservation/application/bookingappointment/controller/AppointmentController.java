package com.reservation.application.bookingappointment.controller;

import com.reservation.application.bookingappointment.service.appointment.AppointmentService;
import com.reservation.application.bookingappointment.service.appointment.AppointmentStatus;
import com.reservation.application.bookingappointment.web.dto.AppointmentDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000")
public class AppointmentController {

    private final AppointmentService appointmentService;
        @PostMapping("/scheduleAppointment")
        public AppointmentStatus scheduleAppointment(@RequestBody AppointmentDTO appointmentDTO)  {
            return appointmentService.checkAppointment(appointmentDTO);
        }
}
