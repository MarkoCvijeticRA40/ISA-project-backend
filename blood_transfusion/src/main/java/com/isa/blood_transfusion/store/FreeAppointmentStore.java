package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.FreeAppointment;
import com.isa.blood_transfusion.model.RegisteredUser;
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

}
