package com.reservation.application.bookingappointment.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void testEquals() {
        Appointment appointment1 = new Appointment(1L, "John", "Doe", 30, "Flu", "john@example.com", 1234567890L, "2023-08-01", "10:00 AM");
        Appointment appointment2 = new Appointment(1L, "John", "Doe", 30, "Flu", "john@example.com", 1234567890L, "2023-08-01", "10:00 AM");
        Appointment appointment3 = new Appointment(2L, "Alice", "Smith", 25, "Cold", "alice@example.com", 9876543210L, "2023-08-02", "11:00 AM");

        assertEquals(appointment1, appointment2);
        assertNotEquals(appointment1, appointment3);
    }

    @Test
    void canEqual() {
        Appointment appointment1 = new Appointment(1L, "John", "Doe", 30, "Flu", "john@example.com", 1234567890L, "2023-08-01", "10:00 AM");
        Appointment appointment2 = new Appointment(1L, "John", "Doe", 30, "Flu", "john@example.com", 1234567890L, "2023-08-01", "10:00 AM");

        assertTrue(appointment1.canEqual(appointment2));
    }

    @Test
    void testHashCode() {
        Appointment appointment1 = new Appointment(1L, "John", "Doe", 30, "Flu", "john@example.com", 1234567890L, "2023-08-01", "10:00 AM");
        Appointment appointment2 = new Appointment(1L, "John", "Doe", 30, "Flu", "john@example.com", 1234567890L, "2023-08-01", "10:00 AM");

        assertEquals(appointment1.hashCode(), appointment2.hashCode());
    }

    @Test
    void getId() {
        Appointment appointment = new Appointment();
        appointment.setId(1L);

        assertEquals(1L, appointment.getId());
    }

    @Test
    void getFirstName() {
        Appointment appointment = new Appointment();
        appointment.setFirstName("John");

        assertEquals("John", appointment.getFirstName());
    }

    @Test
    void getLastName() {
        Appointment appointment = new Appointment();
        appointment.setLastName("Doe");

        assertEquals("Doe", appointment.getLastName());
    }

    @Test
    void getAge() {
        Appointment appointment = new Appointment();
        appointment.setAge(30);

        assertEquals(30, appointment.getAge());
    }

    @Test
    void getDisease() {
        Appointment appointment = new Appointment();
        appointment.setDisease("Flu");

        assertEquals("Flu", appointment.getDisease());
    }

    @Test
    void getEmailId() {
        Appointment appointment = new Appointment();
        appointment.setEmailId("john@example.com");

        assertEquals("john@example.com", appointment.getEmailId());
    }

    @Test
    void getContactNumber() {
        Appointment appointment = new Appointment();
        appointment.setContactNumber(1234567890L);

        assertEquals(1234567890L, appointment.getContactNumber());
    }

    @Test
    void getSelectedDate() {
        Appointment appointment = new Appointment();
        appointment.setSelectedDate("2023-08-01");

        assertEquals("2023-08-01", appointment.getSelectedDate());
    }

    @Test
    void getSelectedTime() {
        Appointment appointment = new Appointment();
        appointment.setSelectedTime("10:00 AM");

        assertEquals("10:00 AM", appointment.getSelectedTime());
    }

    @Test
    void setId() {
        Appointment appointment = new Appointment();
        appointment.setId(1L);

        assertEquals(1L, appointment.getId());
    }

    @Test
    void setFirstName() {
        Appointment appointment = new Appointment();
        appointment.setFirstName("John");

        assertEquals("John", appointment.getFirstName());
    }

    @Test
    void setLastName() {
        Appointment appointment = new Appointment();
        appointment.setLastName("Doe");

        assertEquals("Doe", appointment.getLastName());
    }

    @Test
    void setAge() {
        Appointment appointment = new Appointment();
        appointment.setAge(30);

        assertEquals(30, appointment.getAge());
    }

    @Test
    void setDisease() {
        Appointment appointment = new Appointment();
        appointment.setDisease("Flu");

        assertEquals("Flu", appointment.getDisease());
    }

    @Test
    void setEmailId() {
        Appointment appointment = new Appointment();
        appointment.setEmailId("john@example.com");

        assertEquals("john@example.com", appointment.getEmailId());
    }

    @Test
    void setContactNumber() {
        Appointment appointment = new Appointment();
        appointment.setContactNumber(1234567890L);

        assertEquals(1234567890L, appointment.getContactNumber());
    }

    @Test
    void setSelectedDate() {
        Appointment appointment = new Appointment();
        appointment.setSelectedDate("2023-08-01");

        assertEquals("2023-08-01", appointment.getSelectedDate());
    }

    @Test
    void setSelectedTime() {
        Appointment appointment = new Appointment();
        appointment.setSelectedTime("10:00 AM");

        assertEquals("10:00 AM", appointment.getSelectedTime());
    }

    @Test
    void testToString() {
        Appointment appointment = new Appointment(1L, "John", "Doe", 30, "Flu", "john@example.com", 1234567890L, "2023-08-01", "10:00 AM");

        String expectedToString = "Appointment(id=1, firstName=John, lastName=Doe, age=30, disease=Flu, emailId=john@example.com, contactNumber=1234567890, selectedDate=2023-08-01, selectedTime=10:00 AM)";
        assertEquals(expectedToString, appointment.toString());
    }
}
