package com.reservation.application.bookingappointment.repository;

import com.reservation.application.bookingappointment.entity.SignUp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class SignUpRepoTest {
    private final SignUpRepo signUpRepo;
    private SignUp signUp;
    @Autowired
    public SignUpRepoTest(SignUpRepo signUpRepo) {
        this.signUpRepo = signUpRepo;
    }

    @BeforeEach
    public void setup(){

    }

    @Test
    public void givenSignUpObject_whenSaveSignUp_thenSignUpObject(){

        SignUp signUp = SignUp.builder().personalNumber(123456789l).
                        userId("abcd@gmail.com").
                        password("123456tyu").build();

        SignUp savedData = signUpRepo.save(signUp);
        Assertions.assertThat(savedData).isNotNull();
        Assertions.assertThat(savedData.getId()).isGreaterThan(0);
    }

    @Test
    public void givenUsers_whenGetAllUsers_thenGetListOfSignUpUsers(){
        SignUp user1 = SignUp.builder().personalNumber(123456789l).
                userId("abcd@gmail.com").
                password("123456tyu").build();
        SignUp user2 = SignUp.builder().personalNumber(123456788l).
                userId("abd@gmail.com").
                password("123456ty").build();

        SignUp user3 = SignUp.builder().personalNumber(1234567877l).
                userId("acd@gmail.com").
                password("123456tuy").build();
        signUpRepo.save(user1);
        signUpRepo.save(user2);
        signUpRepo.save(user3);
        List<SignUp> users = signUpRepo.findAll();
        Assertions.assertThat(users.size()).isNotNull();
        Assertions.assertThat(users.size()).isEqualTo(3);
    }

    @Test
    public void givenUserPersonalNumber_whenCheckCountOfUsersWithPersonalNumber_thenGetUsersCount(){
        SignUp user1 = SignUp.builder().personalNumber(123456789l).
                userId("abcd@gmail.com").
                password("123456tyu").build();
        SignUp user2 = SignUp.builder().personalNumber(123456788l).
                userId("abd@gmail.com").
                password("123456ty").build();

        SignUp user3 = SignUp.builder().personalNumber(1234567877l).
                userId("acd@gmail.com").
                password("123456tuy").build();
        signUpRepo.save(user1);
        signUpRepo.save(user2);
        signUpRepo.save(user3);
      long value = signUpRepo.checkPersonalNumber(123456788l);
        Assertions.assertThat(value).isNotNull();
        Assertions.assertThat(value).isEqualTo(0);
    }
}