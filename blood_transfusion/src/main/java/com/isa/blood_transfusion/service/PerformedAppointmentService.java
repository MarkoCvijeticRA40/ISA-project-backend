package com.isa.blood_transfusion.service;

public interface PerformedAppointmentService {
    Boolean hasDonatedBloodInLastSixMonths(Long registeredUserId);
}
