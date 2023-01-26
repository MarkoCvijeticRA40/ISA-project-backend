package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.CanceledAppointment;
import com.isa.blood_transfusion.store.CanceledAppointmentStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class CanceledAppointmentServiceImpl implements CanceledAppointmentService {
    private final CanceledAppointmentStore store;

    @Override
    public CanceledAppointment save(CanceledAppointment canceledAppointment) {
        return store.save(canceledAppointment);
    }

    @Override
    public List<CanceledAppointment> get(Long registeredUserId) {
        return store.get(registeredUserId);
    }
}
