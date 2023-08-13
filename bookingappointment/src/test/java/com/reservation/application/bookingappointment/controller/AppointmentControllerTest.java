package com.reservation.application.bookingappointment.controller;

import com.reservation.application.bookingappointment.service.appointment.AppointmentService;
import com.reservation.application.bookingappointment.web.dto.AppointmentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.reservation.application.bookingappointment.service.appointment.AppointmentStatus.CONFIRMED;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AppointmentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AppointmentService appointmentService;

    @InjectMocks
    private AppointmentController appointmentController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentController).build();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testScheduleAppointmentForSuccessfulCase() throws Exception {

        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setFirstName("John");
        appointmentDTO.setLastName("Doe");
        appointmentDTO.setAge(30);
        appointmentDTO.setDisease("Fever");
        appointmentDTO.setEmailId("john.doe@example.com");
        appointmentDTO.setContactNumber(1234567890L);
        appointmentDTO.setSelectedDate("2023-08-01");
        appointmentDTO.setSelectedTime("09:00 AM");


        when(appointmentService.checkAppointment(appointmentDTO)).thenReturn(CONFIRMED);


        mockMvc.perform(post("/api/v1/scheduleAppointment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(appointmentDTO)))
                .andExpect(status().isOk());

        verify(appointmentService, times(1)).checkAppointment(appointmentDTO);
    }


    private String asJsonString(Object obj) {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
