package com.isa.blood_transfusion.repository;
import com.isa.blood_transfusion.entity.FreeAppointmentEntity;
import com.isa.blood_transfusion.model.FreeAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeAppointmentRepository extends JpaRepository<FreeAppointmentEntity, Long> {

}
