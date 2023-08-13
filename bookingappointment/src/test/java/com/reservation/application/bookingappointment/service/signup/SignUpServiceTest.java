package com.reservation.application.bookingappointment.service.signup;

import com.reservation.application.bookingappointment.entity.SignUp;
import com.reservation.application.bookingappointment.repository.SignUpRepo;
import com.reservation.application.bookingappointment.validations.Validations;
import com.reservation.application.bookingappointment.web.dto.SignUpDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
class SignUpServiceTest {

    @Mock
    private SignUpRepo signUpRepo;

    @InjectMocks
    private SignUpServiceImpl signUpService;
    @Mock
    private Validations validations;

    @Mock
    private ModelMapper modelMapper;

   /* @BeforeEach
    public void setUp(){
        signUpRepo = Mockito.mock(SignUpRepo.class);

        validations = Mockito.mock(Validations.class);
         modelMapper = Mockito.mock(ModelMapper.class);
        signUpService = new SignUpServiceImpl(signUpRepo,modelMapper,validations);

    }*/

    @Test
    public  void givenSignUpObject_whenRegisterUser_thenReturnSignUpObject(){
        SignUpDTO signUpDTO = new SignUpDTO();
        SignUp signUp = new SignUp();
        signUpDTO.setPassword("1234567");
        signUpDTO.setUserId("abcr@gm.com");
        signUpDTO.setPersonalNumber(123456789l);

        signUpDTO.setId(1l);


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(signUpDTO.getPassword());
        signUpDTO.setPassword(encodedPassword);

        BDDMockito.given(modelMapper.map(signUpDTO,SignUp.class)).willReturn(signUp);
        BDDMockito.given(validations.isPersonalNumberPresent(signUpDTO.getPersonalNumber())).willReturn(false);
        BDDMockito.given(signUpRepo.save(signUp)).willReturn(signUp);
        SignUpDTO user = signUpService.registration(signUpDTO);
        Assertions.assertThat(user).isNotNull();

    }

}