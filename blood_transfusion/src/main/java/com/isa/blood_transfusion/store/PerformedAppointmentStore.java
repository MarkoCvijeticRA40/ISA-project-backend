package com.isa.blood_transfusion.store;

public interface PerformedAppointmentStore {
    Boolean hasDonatedBloodInLastSixMonths(Long registeredUserId);
}
