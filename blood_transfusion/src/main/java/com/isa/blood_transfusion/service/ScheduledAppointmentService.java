package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.PerformedAppointment;
import com.isa.blood_transfusion.model.ScheduledAppointment;

import java.util.List;

public interface ScheduledAppointmentService {
   ScheduledAppointment save(ScheduledAppointment scheduledAppointment);
   ScheduledAppointment create(Long freeAppointmentId, Long resisteredUserId);

   List<ScheduledAppointment> findAll();


   ScheduledAppointment specificSchedule(String dateString,Long registeredUserId,Long centerId);
}
