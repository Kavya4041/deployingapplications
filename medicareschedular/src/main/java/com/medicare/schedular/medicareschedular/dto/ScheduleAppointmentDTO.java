package com.medicare.schedular.medicareschedular.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ScheduleAppointmentDTO {
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
