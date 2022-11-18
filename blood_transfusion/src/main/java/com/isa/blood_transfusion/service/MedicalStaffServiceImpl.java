package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.MedicalStaff;
import com.isa.blood_transfusion.store.MedicalStaffStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class MedicalStaffServiceImpl implements MedicalStaffService {
    private MedicalStaffStore store;

    @Override
    public MedicalStaff getById(Long id) {
        return store.getById(id);
    }
}
