package com.reservation.application.bookingappointment.web.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AppointmentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String disease;
    private String emailId;
    private Long contactNumber;
    private String selectedDate;
    private String selectedTime;
}
