package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.ScheduledAppointment;

public interface ScheduledAppointmentService {
   ScheduledAppointment save(ScheduledAppointment scheduledAppointment);

   ScheduledAppointment create(Long freeAppointmentId, Long resisteredUserId);
}
