package com.reservation.application.bookingappointment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String disease;
    private String emailId;
    private Long contactNumber;
    private String appointmentStatus;
   // @ManyToMany
   // private Doctor doctor;

}
