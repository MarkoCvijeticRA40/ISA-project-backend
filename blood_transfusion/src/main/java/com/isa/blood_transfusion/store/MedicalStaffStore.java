package com.isa.blood_transfusion.store;
import com.isa.blood_transfusion.model.MedicalStaff;
import com.isa.blood_transfusion.model.Center;

public interface MedicalStaffStore {
    MedicalStaff find(String email);

    MedicalStaff save(MedicalStaff medicalStaff);
    
    MedicalStaff getById(Long id);
}
