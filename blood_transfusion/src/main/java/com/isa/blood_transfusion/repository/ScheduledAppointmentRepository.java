package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.FreeAppointmentEntity;
import com.isa.blood_transfusion.entity.ScheduledAppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduledAppointmentRepository extends JpaRepository<ScheduledAppointmentEntity, Long> {
    List<ScheduledAppointmentEntity> findScheduledAppointmentEntityByRegisteredUserId(Long id);

}
