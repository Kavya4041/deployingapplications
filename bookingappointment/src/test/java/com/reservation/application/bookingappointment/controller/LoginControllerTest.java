package com.reservation.application.bookingappointment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservation.application.bookingappointment.service.login.LoginiService;
import com.reservation.application.bookingappointment.web.dto.LoginDTO;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@WebMvcTest
public class LoginControllerTest {

    @MockBean
    private LoginiService loginiService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void givenLoginObject_whenSaveLoginObject_returnLoginObject() throws Exception {

        LoginDTO loginDTO = LoginDTO.builder().personalNumber(123456789l).id(1l).build();
        BDDMockito.given(loginiService.loggingIn(loginDTO)).willReturn(loginDTO);

        ResultActions response = mockMvc.perform(post("/api/v1/userlogin").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginDTO)));
        response.andExpect(MockMvcResultMatchers.status().isCreated()).
                andExpect(MockMvcResultMatchers.jsonPath("$.personalNumber", CoreMatchers.is(loginDTO.getPersonalNumber())));


    }

}
