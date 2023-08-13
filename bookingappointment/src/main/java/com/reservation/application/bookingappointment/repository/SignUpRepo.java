package com.reservation.application.bookingappointment.repository;

import com.reservation.application.bookingappointment.entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepo extends JpaRepository<SignUp,Long> {

  @Query(value = "SELECT COUNT(personal_number) > 0 FROM signup WHERE  personal_number = :personalNumber", nativeQuery = true)
   long checkPersonalNumber(@Param("personalNumber") Long personalNumber);

  /*  @Query(value = "SELECT personal_number FROM signup WHERE  personal_number = :personalNumber", nativeQuery = true)
   boolean checkPersonalNumber(@Param("personalNumber") Long personalNumber);*/


}
