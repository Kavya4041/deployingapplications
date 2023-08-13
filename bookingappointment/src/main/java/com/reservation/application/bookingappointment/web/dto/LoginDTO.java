package com.reservation.application.bookingappointment.web.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LoginDTO {
    private Long id;
    private Long personalNumber;
}
