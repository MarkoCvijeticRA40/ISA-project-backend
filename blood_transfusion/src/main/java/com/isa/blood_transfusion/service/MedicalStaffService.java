package com.isa.blood_transfusion.service;
import com.isa.blood_transfusion.model.MedicalStaff;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.model.SystemAdministrator;


public interface MedicalStaffService {
    MedicalStaff find(String email);

    MedicalStaff save(MedicalStaff medicalStaff);
}
