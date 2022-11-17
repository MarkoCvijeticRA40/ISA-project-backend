package com.isa.blood_transfusion.service;
import com.isa.blood_transfusion.model.MedicalStaff;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.model.SystemAdministrator;
import com.isa.blood_transfusion.store.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class MedicalStaffServiceImpl implements MedicalStaffService {
    private final MedicalStaffStore store;

    @Override
    public MedicalStaff find(String email) {
        return store.find(email);
    }

    @Override
    public MedicalStaff save(MedicalStaff medicalStaff) {
        return store.save(medicalStaff);
    }
}