package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.CenterEntity;
import com.isa.blood_transfusion.entity.FreeAppointmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface FreeAppointmentRepository extends JpaRepository<FreeAppointmentEntity, Long> {
    Page<FreeAppointmentEntity> findAll(Pageable pageable);

    @Query("SELECT a from free_appointments a where a.date=:localDate")
    Page<FreeAppointmentEntity> findByDate(@Param("localDate") LocalDateTime localDate, Pageable pageable);

    List<FreeAppointmentEntity> findFreeAppointmentEntityByCenterId(Long id);

    default FreeAppointmentEntity getById(Long id) {
        return findById(id).orElse(null);
    }
    List<FreeAppointmentEntity> findByOrderByDateAsc();
    List<FreeAppointmentEntity> findByOrderByDateDesc();

}

