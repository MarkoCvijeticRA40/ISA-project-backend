package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.CanceledAppointment;
import com.isa.blood_transfusion.model.ScheduledAppointment;

import java.util.List;

public interface CanceledAppointmentStore {
    CanceledAppointment save(CanceledAppointment canceledAppointment);
    List<CanceledAppointment> get(Long registeredUserId);
}
