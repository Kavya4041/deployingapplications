package com.reservation.application.bookingappointment.repository;

import com.reservation.application.bookingappointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    @Query(value = "SELECT COUNT(available_date)>0,count(available_time)>0  FROM appointmentsdb.doctor WHERE  available_date = :selectedDate and available_time = :selectedTime", nativeQuery = true)
    Long checkAppointmentDateAndTime(@Param("selectedDate") String selectedDate , @Param("selectedTime") String selectedTime);


}
