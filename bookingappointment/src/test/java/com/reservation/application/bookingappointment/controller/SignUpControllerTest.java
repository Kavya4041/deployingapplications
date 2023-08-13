package com.reservation.application.bookingappointment.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservation.application.bookingappointment.entity.SignUp;
import com.reservation.application.bookingappointment.service.signup.SignUpService;
import com.reservation.application.bookingappointment.web.dto.SignUpDTO;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SignUpController.class)
public class SignUpControllerTest {

    @Autowired
    private MockMvc mockMvc;//to call rest apis

    @MockBean
    private SignUpService signUpService;

    @Autowired
    private ObjectMapper objectMapper;//to map the objects to JSON format(to serialise and deserialise java objects)


    @Test

    public void givenSignUpObject_whenCreateUsers_thenReturnUsers() throws Exception {
        //given
        SignUpDTO signUpDTO = SignUpDTO.builder().personalNumber(123446789l).
                userId("abcd@gmail.com").password("123apple").id(1l).build();
        BDDMockito.given(signUpService.registration(ArgumentMatchers.any(SignUpDTO.class))).willReturn(signUpDTO);

        ResultActions response = mockMvc.perform(post("/api/v1/newusers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(signUpDTO)));

        //when
        response.andExpect(MockMvcResultMatchers.status().isCreated()).
                andExpect(MockMvcResultMatchers.jsonPath("$.personalNumber",CoreMatchers.is(signUpDTO.getPersonalNumber()))).
                andExpect(MockMvcResultMatchers.jsonPath("$.userId",CoreMatchers.is(signUpDTO.getUserId()))).
                andExpect(MockMvcResultMatchers.jsonPath("$.password",CoreMatchers.is(signUpDTO.getPassword()))).

                andExpect(MockMvcResultMatchers.jsonPath("$.id",CoreMatchers.is(signUpDTO.getId())));
        //then

    }

}
