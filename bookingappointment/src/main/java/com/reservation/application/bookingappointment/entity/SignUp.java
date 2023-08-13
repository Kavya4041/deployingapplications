package com.reservation.application.bookingappointment.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="signup")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long personalNumber;
    @Column(nullable = false, length = 64,unique = true)
    private String userId;
    @Column(nullable = false, unique = true)
    private String password;

}
