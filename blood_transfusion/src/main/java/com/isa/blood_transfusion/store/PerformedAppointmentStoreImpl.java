package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.entity.PerformedAppointmentEntity;
import com.isa.blood_transfusion.repository.PerformedAppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class PerformedAppointmentStoreImpl implements PerformedAppointmentStore{
    private final PerformedAppointmentRepository repository;

    @Override
    public Boolean hasDonatedBloodInLastSixMonths(Long registeredUserId) {
        for (PerformedAppointmentEntity performedAppointment : repository.findPerformedAppointmentEntityByRegisteredUserId(registeredUserId)) {
            if (performedAppointment.getDate().plusMonths(6L).isAfter(LocalDateTime.now()))
                return true;
        }

        return false;
    }
}
