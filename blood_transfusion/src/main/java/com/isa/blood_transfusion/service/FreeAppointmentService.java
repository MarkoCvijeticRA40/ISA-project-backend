package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.FreeAppointment;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface FreeAppointmentService {
    FreeAppointment save(FreeAppointment freeAppointment);

    List<FreeAppointment> getByDate(LocalDateTime date, Pageable pageable);

    List<FreeAppointment> get(Long centerId);

    boolean isDateValid(FreeAppointment freeAppointment);

    boolean isDateOverlapping(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2);

    boolean hasCenterFreeAppointmentInThisTerm(Long centerId, LocalDateTime date);

    List<FreeAppointment> findByDateAsc(Long centerId, Long registeredUserId);

    List<FreeAppointment> findByDateDesc(Long centerId, Long registeredUserId);

    List<FreeAppointment> get(Long centerId, Long registeredUserId);
}
