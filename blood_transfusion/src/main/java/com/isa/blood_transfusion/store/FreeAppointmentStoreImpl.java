package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.FreeAppointmentConverter;
import com.isa.blood_transfusion.model.FreeAppointment;
import com.isa.blood_transfusion.repository.FreeAppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FreeAppointmentStoreImpl implements FreeAppointmentStore {

    private final FreeAppointmentRepository repository;
    private final FreeAppointmentConverter converter;

    @Override
    public FreeAppointment save(FreeAppointment freeAppointment) {
        repository.save(converter.toEntity(freeAppointment));
        return freeAppointment;
    }
}
