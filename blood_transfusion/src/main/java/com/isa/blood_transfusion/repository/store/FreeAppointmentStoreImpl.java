package com.isa.blood_transfusion.repository.store;

import com.isa.blood_transfusion.converter.FreeAppointmentConverter;
import com.isa.blood_transfusion.model.FreeAppointment;
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

    @Override
    public List<FreeAppointment> get(Long centerId) {
        return converter.toModel(repository.findFreeAppointmentEntityByCenterId(centerId).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public FreeAppointment getById(Long id) {
        return converter.toModel(repository.getById(id));
    }

    @Override
    public void delete(FreeAppointment freeAppointment) {
        repository.delete(converter.toEntity(freeAppointment));
    }
}
