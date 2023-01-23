package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.ScheduledAppointmentConverter;
import com.isa.blood_transfusion.model.FreeAppointment;
import com.isa.blood_transfusion.model.ScheduledAppointment;
import com.isa.blood_transfusion.model.UserCategory;
import com.isa.blood_transfusion.repository.ScheduledAppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ScheduledAppointmentStoreImpl implements ScheduledAppointmentStore{

    private final ScheduledAppointmentRepository repository;
    private final ScheduledAppointmentConverter converter;

    @Override
    public ScheduledAppointment save(ScheduledAppointment scheduledAppointment) {
        repository.save(converter.toEntity(scheduledAppointment));
        return scheduledAppointment;
    }

}
