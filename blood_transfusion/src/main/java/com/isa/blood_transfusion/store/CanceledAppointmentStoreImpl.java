package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.CanceledAppointmentConverter;
import com.isa.blood_transfusion.model.CanceledAppointment;
import com.isa.blood_transfusion.repository.CanceledAppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CanceledAppointmentStoreImpl implements CanceledAppointmentStore {
    private final CanceledAppointmentRepository repository;
    private final CanceledAppointmentConverter converter;

    @Override
    public CanceledAppointment save(CanceledAppointment canceledAppointment) {
        repository.save(converter.toEntity(canceledAppointment));
        return canceledAppointment;
    }

    @Override
    public List<CanceledAppointment> get(Long registeredUserId) {
        return converter.toModel(repository.findCanceledAppointmentEntityByRegisteredUserId(registeredUserId).stream().collect(Collectors.toSet())).stream().toList();
    }

}
