package com.reservation.application.bookingappointment.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignUpTest {

    @Test
    void testEquals() {
        SignUp signUp1 = new SignUp(1L, 12345l, "john_doe", "password");
        SignUp signUp2 = new SignUp(1L, 12345l, "john_doe", "password");
        SignUp signUp3 = new SignUp(2L, 67890l, "alice_smith", "password");

        assertEquals(signUp1, signUp2);
        assertNotEquals(signUp1, signUp3);
    }



    @Test
    void testHashCode() {
        SignUp signUp1 = new SignUp(1L, 12345l, "john_doe", "password");
        SignUp signUp2 = new SignUp(1L, 12345l, "john_doe", "password");

        assertEquals(signUp1.hashCode(), signUp2.hashCode()); 
    }

    @Test
    void getId() {
        SignUp signUp = new SignUp();
        signUp.setId(1L);

        assertEquals(1L, signUp.getId());
    }

    @Test
    void getPersonalNumber() {
        SignUp signUp = new SignUp();
        signUp.setPersonalNumber(12345l);

        assertEquals(12345l, signUp.getPersonalNumber());
    }

    @Test
    void getUserId() {
        SignUp signUp = new SignUp();
        signUp.setUserId("john_doe");

        assertEquals("john_doe", signUp.getUserId());
    }

    @Test
    void getPassword() {
        SignUp signUp = new SignUp();
        signUp.setPassword("password");

        assertEquals("password", signUp.getPassword());
    }

    @Test
    void setId() {
        SignUp signUp = new SignUp();
        signUp.setId(1L);

        assertEquals(1L, signUp.getId());
    }

    @Test
    void setPersonalNumber() {
        SignUp signUp = new SignUp();
        signUp.setPersonalNumber(12345l);

        assertEquals(12345l, signUp.getPersonalNumber());
    }

    @Test
    void setUserId() {
        SignUp signUp = new SignUp();
        signUp.setUserId("john_doe");

        assertEquals("john_doe", signUp.getUserId());
    }

    @Test
    void setPassword() {
        SignUp signUp = new SignUp();
        signUp.setPassword("password");

        assertEquals("password", signUp.getPassword());
    }

    @Test
    void testToString() {
        SignUp signUp = new SignUp(1L, 12345l, "john_doe", "password");

        String expectedToString = "SignUp(id=1, personalNumber=12345, userId=john_doe, password=password)";
        assertEquals(expectedToString, signUp.toString());
    }
}
