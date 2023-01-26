package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.MedicalStaff;


public interface MedicalStaffService {
    MedicalStaff find(String email);

    MedicalStaff save(MedicalStaff medicalStaff);

    MedicalStaff getById(Long id);

    MedicalStaff saveStaff(MedicalStaff medicalStaff);

    boolean isPasswordChanged(String email, String password);

}
