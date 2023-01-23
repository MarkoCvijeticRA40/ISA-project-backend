package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.PerformedAppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformedAppointmentRepository extends JpaRepository<PerformedAppointmentEntity, Long> {
    List<PerformedAppointmentEntity> findPerformedAppointmentEntityByRegisteredUserId(Long registeredUserId);
}
