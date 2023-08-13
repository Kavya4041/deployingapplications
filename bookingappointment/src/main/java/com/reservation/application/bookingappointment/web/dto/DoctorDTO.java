package com.reservation.application.bookingappointment.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorDTO {
    private long id;
    private String name;
    private String bookedDate;
    private String bookedTime;
    private String description;
}
