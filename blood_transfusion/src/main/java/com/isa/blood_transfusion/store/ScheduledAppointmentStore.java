package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.ScheduledAppointment;

import java.util.List;

public interface ScheduledAppointmentStore {

    ScheduledAppointment save(ScheduledAppointment scheduledAppointment);
    List<ScheduledAppointment> findAll();


    List<ScheduledAppointment> findByCenterId(Long id);



    List<ScheduledAppointment> get(Long registeredUserId);
    ScheduledAppointment delete(ScheduledAppointment scheduledAppointment);
    ScheduledAppointment getById(Long scheduledAppointmentId);
}
