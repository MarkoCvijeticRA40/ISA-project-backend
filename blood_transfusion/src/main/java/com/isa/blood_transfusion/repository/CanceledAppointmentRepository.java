package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.CanceledAppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CanceledAppointmentRepository extends JpaRepository<CanceledAppointmentEntity, Long> {
    List<CanceledAppointmentEntity> findCanceledAppointmentEntityByRegisteredUserId(Long registeredUserId);
}
