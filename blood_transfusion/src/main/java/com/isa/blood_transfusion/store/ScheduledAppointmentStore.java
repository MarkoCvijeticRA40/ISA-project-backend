package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.ScheduledAppointment;

public interface ScheduledAppointmentStore {

    ScheduledAppointment save(ScheduledAppointment scheduledAppointment);
}
