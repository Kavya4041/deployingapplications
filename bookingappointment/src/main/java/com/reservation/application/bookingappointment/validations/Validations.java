package com.reservation.application.bookingappointment.validations;

public interface Validations {
    public boolean isPersonalNumberPresent(Long personalNumber);
    public boolean isAppointmentAvailable(String bookedDate, String bookedTime);
}
