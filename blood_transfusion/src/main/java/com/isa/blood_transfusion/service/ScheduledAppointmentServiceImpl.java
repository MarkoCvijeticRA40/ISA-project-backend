package com.isa.blood_transfusion.service;


import com.isa.blood_transfusion.model.ScheduledAppointment;
import com.isa.blood_transfusion.store.ScheduledAppointmentStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class ScheduledAppointmentServiceImpl implements  ScheduledAppointmentService {

    private final ScheduledAppointmentStore store;

    @Override
    public ScheduledAppointment save(ScheduledAppointment scheduledAppointment) {
        return store.save(scheduledAppointment);
    }

}
