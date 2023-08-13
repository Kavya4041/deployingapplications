package com.reservation.application.bookingappointment.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void getId() {
        Login login = new Login();
        login.setId(1L);
        assertEquals(1L, login.getId());
    }

    @Test
    void getPersonalNumber() {

        Login login = new Login();
        login.setPersonalNumber(12345l);
        assertEquals(12345l, login.getPersonalNumber());
    }

    @Test
    void setId() {

        Login login = new Login();
        login.setId(1L);
        assertEquals(1L, login.getId());
    }

    @Test
    void setPersonalNumber() {
        Login login = new Login();
        login.setPersonalNumber(12345l);
        assertEquals(12345l, login.getPersonalNumber());
    }

    @Test
    void testToString() {

        Login login = new Login();
        login.setId(1L);
        login.setPersonalNumber(12345L);
        String expectedToString = "Login(id=1, personalNumber=12345)";
        assertEquals(expectedToString, login.toString());
    }
}
