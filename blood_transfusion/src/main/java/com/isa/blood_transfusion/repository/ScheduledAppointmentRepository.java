package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.RegisteredUserEntity;
import com.isa.blood_transfusion.entity.FreeAppointmentEntity;
import com.isa.blood_transfusion.entity.ScheduledAppointmentEntity;
import com.isa.blood_transfusion.model.ScheduledAppointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

import java.util.List;



public interface ScheduledAppointmentRepository extends JpaRepository<ScheduledAppointmentEntity, Long> {
    List<ScheduledAppointmentEntity> findScheduledAppointmentEntityByRegisteredUserId(Long id);
    default ScheduledAppointmentEntity getById(Long id) {
        return findById(id).orElse(null);
    }

    @Query(value ="select * from scheduled_appointments where center_id = ?1", nativeQuery = true)
    List<ScheduledAppointmentEntity> findByCenterId(Long id);
}
