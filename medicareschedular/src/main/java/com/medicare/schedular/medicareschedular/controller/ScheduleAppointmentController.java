package com.medicare.schedular.medicareschedular.controller;

import com.medicare.schedular.medicareschedular.dto.ScheduleAppointmentDTO;
import com.medicare.schedular.medicareschedular.service.ScheduleAppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
//@CrossOrigin("http://localhost:3000")
public class ScheduleAppointmentController {

    private final ScheduleAppointmentService appointmentService;
    @PostMapping("/scheduleAppointment")
    public void scheduleAppointment(@RequestBody ScheduleAppointmentDTO appointmentDTO)  {
        appointmentService.checkAppointment(appointmentDTO);
    }
}