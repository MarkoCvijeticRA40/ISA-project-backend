package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.FreeAppointmentConverter;
import com.isa.blood_transfusion.model.FreeAppointment;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.repository.FreeAppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<FreeAppointment> findAll() {
        return converter.toModel(repository.findAll().stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<FreeAppointment> findAll(Pageable pageable) {
        return converter.toModel(repository.findAll(pageable).toSet()).stream().toList();
    }

    @Override
    public List<FreeAppointment> getByDate(LocalDateTime date, Pageable pageable) {
        return converter.toModel(repository.findByDate(date, pageable).toSet()).stream().toList();
    }
}
