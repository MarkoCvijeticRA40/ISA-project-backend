package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.Center;
import com.isa.blood_transfusion.model.MedicalStaff;

public interface MedicalStaffStore {
    MedicalStaff getById(Long id);
}
