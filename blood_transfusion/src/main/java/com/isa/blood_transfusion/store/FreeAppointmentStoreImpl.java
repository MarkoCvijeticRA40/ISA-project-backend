package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.FreeAppointmentConverter;
import com.isa.blood_transfusion.repository.FreeAppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FreeAppointmentStoreImpl implements FreeAppointmentStore{

    private final FreeAppointmentRepository repository;
    private final FreeAppointmentConverter converter;


}
