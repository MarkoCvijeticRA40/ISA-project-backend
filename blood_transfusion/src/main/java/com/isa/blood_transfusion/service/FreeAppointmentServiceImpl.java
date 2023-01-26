package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.FreeAppointment;
import com.isa.blood_transfusion.model.ScheduledAppointment;
import com.isa.blood_transfusion.store.FreeAppointmentStore;
import com.isa.blood_transfusion.store.ScheduledAppointmentStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class FreeAppointmentServiceImpl implements FreeAppointmentService {

    private final FreeAppointmentStore store;
    private final ScheduledAppointmentStore scheduledAppointmentStore;

    @Override
    public FreeAppointment save(FreeAppointment freeAppointment) {

        if (isDateValid(freeAppointment) == true) {
            freeAppointment.setDate(freeAppointment.getDate().minusHours(1));
            return store.save(freeAppointment);
        } else {
            return null;
        }
    }

    @Override
    public List<FreeAppointment> getByDate(LocalDateTime date, Pageable pageable) {
        return store.getByDate(date, pageable);
    }

    @Override
    public List<FreeAppointment> get(Long centerId) {
        return store.get(centerId);
    }

    @Override
    public List<FreeAppointment> findByDateAsc() {
        return store.findByDateAsc();
    }

    @Override
    public List<FreeAppointment> findByDateDesc() {
        return store.findByDateDesc();
    }

    public boolean isDateValid(FreeAppointment freeAppointment) {

        List<FreeAppointment> freeAppointments = store.findByCenterId(freeAppointment.getCenter().getId());
        freeAppointment.setDate(freeAppointment.getDate().plusHours(1));

        LocalDateTime freeAppointmentEnd;
        freeAppointmentEnd = freeAppointment.getDate().plusMinutes(freeAppointment.getDuration());

        List<ScheduledAppointment> scheduledAppointments = scheduledAppointmentStore.findByCenterId(freeAppointment.getCenter().getId());

        for (FreeAppointment freeApp : freeAppointments) {

            LocalDateTime freeAppEnd;
            freeAppEnd = freeApp.getDate().plusMinutes(freeApp.getDuration());

            if (isDateOverlapping(freeAppointment.getDate(), freeAppointmentEnd, freeApp.getDate(), freeAppEnd) == true) {

                return false;
            }
        }

        for (ScheduledAppointment scheApp : scheduledAppointments) {

            LocalDateTime scheAppEnd;
            scheAppEnd = scheApp.getDate().plusMinutes(scheApp.getDuration());

            if (isDateOverlapping(freeAppointment.getDate(), freeAppointmentEnd,scheApp.getDate(),scheAppEnd) == true) {

                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isDateOverlapping(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return start2.isBefore(end1) && end2.isAfter(start1);
    }

    @Override
    public boolean hasCenterFreeAppointmentInThisTerm(Long centerId, LocalDateTime date) {

        List<FreeAppointment> freeAppointments = store.get(centerId);

        for (FreeAppointment freeappointment : freeAppointments) {

            if (freeappointment.getDate().toString().equals(date.toString()) && freeappointment.getCenter().getId() == centerId) {

                return true;
            }
        }
        return false;
    }
}


