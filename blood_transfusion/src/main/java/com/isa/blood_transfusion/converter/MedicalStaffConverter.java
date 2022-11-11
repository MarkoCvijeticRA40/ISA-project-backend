package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.MedicalStaffEntity;
import com.isa.blood_transfusion.model.MedicalStaff;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MedicalStaffConverter {
    private RoleConverter roleConverter;
    private AddressConverter addressConverter;
    private UserCategoryConverter userCategoryConverter;

    public MedicalStaff toModel(MedicalStaffEntity medicalStaffEntity) {
        return new MedicalStaff(medicalStaffEntity.getId(),
                medicalStaffEntity.getEmail(),
                medicalStaffEntity.getPassword(),
                medicalStaffEntity.getName(),
                medicalStaffEntity.getSurname(),
                medicalStaffEntity.getPhoneNum(),
                medicalStaffEntity.getIdentityNumber(),
                medicalStaffEntity.getProfession(),
                medicalStaffEntity.getFacilityInfo(),
                roleConverter.toModel(medicalStaffEntity.getRole()),
                addressConverter.toModel(medicalStaffEntity.getAddress()),
                medicalStaffEntity.getGender());
    }

    public Set<MedicalStaff> toModel(Set<MedicalStaffEntity> medicalStaffEntities) {
        Set<MedicalStaff> medicalStaff = new HashSet<>();
        for (var m : medicalStaffEntities) {
            medicalStaff.add(new MedicalStaff(m.getId(),
                    m.getEmail(),
                    m.getPassword(),
                    m.getName(),
                    m.getSurname(),
                    m.getPhoneNum(),
                    m.getIdentityNumber(),
                    m.getProfession(),
                    m.getFacilityInfo(),
                    roleConverter.toModel(m.getRole()),
                    addressConverter.toModel(m.getAddress()),
                    m.getGender()));
        }

        return medicalStaff;
    }
}
