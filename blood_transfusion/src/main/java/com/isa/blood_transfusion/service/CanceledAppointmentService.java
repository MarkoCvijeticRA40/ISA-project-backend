package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.CanceledAppointment;

import java.util.List;

public interface CanceledAppointmentService {
    CanceledAppointment save(CanceledAppointment canceledAppointment);
    List<CanceledAppointment> get(Long registeredUserId);
}
