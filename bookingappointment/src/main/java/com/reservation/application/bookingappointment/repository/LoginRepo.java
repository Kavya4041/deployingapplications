package com.reservation.application.bookingappointment.repository;

import com.reservation.application.bookingappointment.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login,Long> {

}
