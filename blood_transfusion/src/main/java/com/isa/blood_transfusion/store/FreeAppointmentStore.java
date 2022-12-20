package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.AppUser;
import com.isa.blood_transfusion.model.FreeAppointment;

public interface FreeAppointmentStore {
    FreeAppointment save(FreeAppointment freeAppointment);
}
