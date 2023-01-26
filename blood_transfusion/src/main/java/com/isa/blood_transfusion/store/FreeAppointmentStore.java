package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.FreeAppointment;
import com.isa.blood_transfusion.model.MedicalStaff;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface FreeAppointmentStore {
    FreeAppointment save(FreeAppointment freeAppointment);

    List<FreeAppointment> findAll();

    List<FreeAppointment> findAll(Pageable pageable);

    List<FreeAppointment> getByDate(LocalDateTime date, Pageable pageable);

    List<FreeAppointment> get(Long centerId);

    FreeAppointment getById(Long id);

    void delete(FreeAppointment freeAppointment);

    FreeAppointment getByDateAndCenter(LocalDateTime date, Long centerId);

    MedicalStaff getEmployedMedicalStaff(Long centerId);

    List<FreeAppointment> findByDateAsc(Long centerId);

    List<FreeAppointment> findByDateDesc(Long centerId);

    List<FreeAppointment> findByCenterId(Long centerId);

}
