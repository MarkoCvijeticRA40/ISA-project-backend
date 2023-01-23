package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.ScheduledAppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledAppointmentRepository extends JpaRepository<ScheduledAppointmentEntity, Long> {


}
