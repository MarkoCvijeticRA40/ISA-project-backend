package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.MedicalStaffEntity;
import com.isa.blood_transfusion.model.MedicalStaff;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class MedicalStaffConverter {
    private RoleConverter roleConverter;
    private AddressConverter addressConverter;

    private CenterConverter centerConverter;

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
                medicalStaffEntity.getGender(),
                medicalStaffEntity.isEnabled(),
                medicalStaffEntity.getLastPasswordResetDate()
        );
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
                    m.getGender(),
                    m.isEnabled(),
                    m.getLastPasswordResetDate()
            ));
        }

        return medicalStaff;
    }

    public MedicalStaffEntity toEntity(MedicalStaff medicalStaff) {
        return new MedicalStaffEntity(medicalStaff.getId(),
                medicalStaff.getEmail(),
                medicalStaff.getPassword(),
                medicalStaff.getName(),
                medicalStaff.getSurname(),
                medicalStaff.getPhoneNum(),
                medicalStaff.getIdentityNumber(),
                medicalStaff.getProfession(),
                medicalStaff.getFacilityInfo(),
                roleConverter.toEntity(medicalStaff.getRole()),
                addressConverter.toEntity(medicalStaff.getAddress()),
                medicalStaff.getGender(),
                medicalStaff.isEnabled(),
                medicalStaff.getLastPasswordResetDate()
        );
    }

    public Set<MedicalStaffEntity> toEntity(Set<MedicalStaff> medicalStaff) {
        Set<MedicalStaffEntity> medicalStaffEntities = new HashSet<>();
        for (var m : medicalStaff) {
            medicalStaffEntities.add(new MedicalStaffEntity(m.getId(),
                    m.getEmail(),
                    m.getPassword(),
                    m.getName(),
                    m.getSurname(),
                    m.getPhoneNum(),
                    m.getIdentityNumber(),
                    m.getProfession(),
                    m.getFacilityInfo(),
                    roleConverter.toEntity(m.getRole()),
                    addressConverter.toEntity(m.getAddress()),
                    m.getGender(),
                    m.isEnabled(),
                    m.getLastPasswordResetDate()
            ));
        }
        return medicalStaffEntities;
    }

}