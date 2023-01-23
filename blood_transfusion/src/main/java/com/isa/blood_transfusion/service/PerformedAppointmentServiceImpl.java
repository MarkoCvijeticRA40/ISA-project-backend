package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.store.PerformedAppointmentStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class PerformedAppointmentServiceImpl implements PerformedAppointmentService {
    private final PerformedAppointmentStore store;

    @Override
    public Boolean hasDonatedBloodInLastSixMonths(Long registeredUserId) {
        return store.hasDonatedBloodInLastSixMonths(registeredUserId);
    }
}
