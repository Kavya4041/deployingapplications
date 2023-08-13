package com.reservation.application.bookingappointment.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String firstName;
    @Column(nullable = false, length = 45)
    private String lastName;
    @Column(nullable = false)
    private Integer age;
    private String disease;
    @Column(nullable = false,length = 45)
    private String emailId;
    private Long contactNumber;
    private String selectedDate;
    private String selectedTime;
}
