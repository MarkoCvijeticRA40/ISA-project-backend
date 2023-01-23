package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.FreeAppointment;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.store.FreeAppointmentStore;
import com.isa.blood_transfusion.store.FreeAppointmentStoreImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;
import org.springframework.data.domain.Pageable;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class FreeAppointmentServiceImpl implements FreeAppointmentService {
    private final FreeAppointmentStore store;

    @Override
    public FreeAppointment save(FreeAppointment freeAppointment) {

        if (isDateValid(freeAppointment) == true)
        {
            freeAppointment.setDate(freeAppointment.getDate().minusHours(1));
            return store.save(freeAppointment);
        }
        else
        {
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

    public boolean isDateValid(FreeAppointment freeAppointment) {

        List<FreeAppointment> freeAppointments = store.findAll();
        freeAppointment.setDate(freeAppointment.getDate().plusHours(1));

        for(FreeAppointment freeApp : freeAppointments) {
            if(freeAppointment.getDate().toString().equals(freeApp.getDate().toString())){
                return  false;
            }
        }
        return true;
    }




}

