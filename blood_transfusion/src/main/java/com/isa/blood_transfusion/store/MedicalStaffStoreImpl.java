package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.MedicalStaffConverter;
import com.isa.blood_transfusion.model.MedicalStaff;
import com.isa.blood_transfusion.repository.MedicalStaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class MedicalStaffStoreImpl implements MedicalStaffStore{
    private MedicalStaffRepository repository;
    private MedicalStaffConverter medicalStaffConverter;

    @Override
    public MedicalStaff getById(Long id) {
        if (repository.getById(id) == null) {
            return null;
        } else {
            return medicalStaffConverter.toModel(repository.getById(id));
        }
    }
}
