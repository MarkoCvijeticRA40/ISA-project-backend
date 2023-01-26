package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.CanceledAppointment;

import java.util.List;

public interface CanceledAppointmentStore {
    CanceledAppointment save(CanceledAppointment canceledAppointment);

    List<CanceledAppointment> get(Long registeredUserId);
}
