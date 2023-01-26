package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.ScheduledAppointmentConverter;
import com.isa.blood_transfusion.model.ScheduledAppointment;
import com.isa.blood_transfusion.repository.ScheduledAppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public List<ScheduledAppointment> findAll() {

        return converter.toModel(repository.findAll().stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<ScheduledAppointment> findByCenterId(Long id) {
        return converter.toModel(repository.findByCenterId(id).stream().collect(Collectors.toSet())).stream().toList();
    }
    public List<ScheduledAppointment> get(Long registeredUserId) {
        return converter.toModel(repository.findScheduledAppointmentEntityByRegisteredUserId(registeredUserId).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<ScheduledAppointment> findByCenterId(Long centerId) {
        List<ScheduledAppointment> scheduledAppointments = findAll();
        List<ScheduledAppointment> foundedAppointments = new ArrayList<>();
        for (ScheduledAppointment appointment:scheduledAppointments) {
            if(appointment.getCenter().getId() == centerId) {
                foundedAppointments.add(appointment);
            }
        }
        return foundedAppointments;
    public ScheduledAppointment delete(ScheduledAppointment scheduledAppointment) {
        repository.delete(converter.toEntity(scheduledAppointment));
        return scheduledAppointment;
    }

    @Override
    public ScheduledAppointment getById(Long scheduledAppointmentId) {
        return converter.toModel(repository.getById(scheduledAppointmentId));
    }

}
