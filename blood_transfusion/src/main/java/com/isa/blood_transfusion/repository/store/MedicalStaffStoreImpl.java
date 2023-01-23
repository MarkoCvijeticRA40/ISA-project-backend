package com.isa.blood_transfusion.repository.store;

import com.isa.blood_transfusion.converter.MedicalStaffConverter;
import com.isa.blood_transfusion.model.MedicalStaff;
import com.isa.blood_transfusion.repository.MedicalStaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class MedicalStaffStoreImpl implements MedicalStaffStore {
    private final MedicalStaffRepository repository;
    private final MedicalStaffConverter converter;

    @Override
    public MedicalStaff find(String email) {
        return converter.toModel(repository.findByEmail(email));
    }

    @Override
    public MedicalStaff save(MedicalStaff medicalStaff) {
        repository.save(converter.toEntity(medicalStaff));
        return medicalStaff;
    }

    @Override
    public MedicalStaff getById(Long id) {
        if (repository.getById(id) == null) {
            return null;
        } else {
            return converter.toModel(repository.getById(id));
        }
    }
}