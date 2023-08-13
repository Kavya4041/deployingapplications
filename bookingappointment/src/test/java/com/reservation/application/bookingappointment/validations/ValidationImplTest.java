package com.reservation.application.bookingappointment.validations;

import com.reservation.application.bookingappointment.repository.AppointmentRepo;
import com.reservation.application.bookingappointment.repository.SignUpRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class ValidationImplTest {
    @Mock
    private SignUpRepo signUpRepoMock;

    @Mock
    private AppointmentRepo appointmentRepoMock;

    @InjectMocks
    private ValidationImpl validation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testIsPersonalNumberPresent_WhenNumberExists_ShouldReturnTrue() {

        Long personalNumber = 123456789L;
        when(signUpRepoMock.checkPersonalNumber(personalNumber)).thenReturn(0l);


        boolean result = validation.isPersonalNumberPresent(personalNumber);


        assertTrue(result);
    }

    @Test
    public void testIsPersonalNumberPresent_WhenNumberDoesNotExist_ShouldReturnFalse() {

        Long personalNumber = 987654321L;
        when(signUpRepoMock.checkPersonalNumber(personalNumber)).thenReturn(1l);


        boolean result = validation.isPersonalNumberPresent(personalNumber);


    }

    @Test
    public void testIsAppointmentAvailable_WhenAppointmentExists_ShouldReturnTrue() {

        String selectedDate = "2023-08-04";
        String selectedTime = "15:00";
        when(appointmentRepoMock.checkAppointmentDateAndTime(selectedDate, selectedTime)).thenReturn(1L);
        boolean result = validation.isAppointmentAvailable(selectedDate, selectedTime);

        assertTrue(result);
    }

    @Test
    public void testIsAppointmentAvailable_WhenAppointmentDoesNotExist_ShouldReturnFalse() {

        String selectedDate = "2023-08-04";
        String selectedTime = "15:00";
        when(appointmentRepoMock.checkAppointmentDateAndTime(selectedDate, selectedTime)).thenReturn(0L);


        boolean result = validation.isAppointmentAvailable(selectedDate, selectedTime);


        assertFalse(result);
    }
}
