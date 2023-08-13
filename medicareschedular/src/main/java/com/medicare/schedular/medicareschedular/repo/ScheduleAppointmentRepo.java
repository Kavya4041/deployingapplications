package com.medicare.schedular.medicareschedular.repo;

import com.medicare.schedular.medicareschedular.entity.ScheduleAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleAppointmentRepo extends JpaRepository<ScheduleAppointment,Long> {
}
