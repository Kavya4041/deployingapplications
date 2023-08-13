package com.reservation.application.bookingappointment.service.appointment;

import com.reservation.application.bookingappointment.web.dto.AppointmentDTO;

public interface AppointmentService {
    public AppointmentStatus checkAppointment(AppointmentDTO appointmentDTO);
}
