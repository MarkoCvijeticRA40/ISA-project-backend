package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.MedicalStaff;

import com.isa.blood_transfusion.store.MedicalStaffStore;
import com.isa.blood_transfusion.store.RoleStore;
import com.isa.blood_transfusion.store.UserCategoryStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class MedicalStaffServiceImpl implements MedicalStaffService {

    private final MedicalStaffStore store;
    private final RoleStore roleStore;

    private final UserCategoryStore userCategoryStore;

    private final AppUserService userService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public MedicalStaff find(String email) {
        return store.find(email);
    }

    @Override
    public MedicalStaff saveStaff(MedicalStaff medicalStaff) {
        medicalStaff.setRole(roleStore.find("MEDICAL_STAFF"));
        if(isPasswordChanged(medicalStaff.getEmail(), medicalStaff.getPassword()) == true) {
            medicalStaff.setPassword(passwordEncoder.encode(medicalStaff.getPassword()));
        }
        return store.save(medicalStaff);
    }

    @Override
    public boolean isPasswordChanged(String email,String password) {

        MedicalStaff medicalStaff = store.find(email);

        if (medicalStaff.getPassword().equals(password)){
            return false;
        }
        return true;
    }


    @Override
    public MedicalStaff save(MedicalStaff medicalStaff) {
        return store.save(medicalStaff);
    }


    @Override
    public MedicalStaff getById(Long id) {
        return store.getById(id);
    }
}
