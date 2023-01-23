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
        return store.save(freeAppointment);
    }

    @Override
    public List<FreeAppointment> getByDate(LocalDateTime date, Pageable pageable) {
        return store.getByDate(date, pageable);
    }

    @Override
    public List<FreeAppointment> get(Long centerId) {
        return store.get(centerId);
    }


}

