package com.isa.blood_transfusion.repository.store;

import com.isa.blood_transfusion.model.MedicalStaff;

public interface MedicalStaffStore {
    MedicalStaff find(String email);

    MedicalStaff save(MedicalStaff medicalStaff);

    MedicalStaff getById(Long id);
}
