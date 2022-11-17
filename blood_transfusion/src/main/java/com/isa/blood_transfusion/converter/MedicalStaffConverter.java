package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.MedicalStaffEntity;
import com.isa.blood_transfusion.entity.RegisteredUserEntity;
import com.isa.blood_transfusion.entity.SystemAdministratorEntity;
import com.isa.blood_transfusion.model.MedicalStaff;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.model.SystemAdministrator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class MedicalStaffConverter {
    private RoleConverter roleConverter;
    private AddressConverter addressConverter;


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
                medicalStaffEntity.getGender()
        );
    }

    public Set<MedicalStaff> toModel(Set<MedicalStaffEntity> medicalStaffEntities) {
        Set<MedicalStaff>medicalStaffs = new HashSet<>();
        for (var r : medicalStaffEntities) {
            medicalStaffs.add(new MedicalStaff(r.getId(),
                    r.getEmail(),
                    r.getPassword(),
                    r.getName(),
                    r.getSurname(),
                    r.getPhoneNum(),
                    r.getIdentityNumber(),
                    r.getProfession(),
                    r.getFacilityInfo(),
                    roleConverter.toModel(r.getRole()),
                    addressConverter.toModel(r.getAddress()),
                    r.getGender()
            ));
        }

        return medicalStaffs;
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
                medicalStaff.getGender()
        );
    }

    public Set<MedicalStaffEntity> toEntity(Set<MedicalStaff> medicalStaffs) {
        Set<MedicalStaffEntity> medicalStaffEntities = new HashSet<>();
        for (var r : medicalStaffs) {
            medicalStaffEntities.add(new MedicalStaffEntity(r.getId(),
                    r.getEmail(),
                    r.getPassword(),
                    r.getName(),
                    r.getSurname(),
                    r.getPhoneNum(),
                    r.getIdentityNumber(),
                    r.getProfession(),
                    r.getFacilityInfo(),
                    roleConverter.toEntity(r.getRole()),
                    addressConverter.toEntity(r.getAddress()),
                    r.getGender()
            ));
        }
        return medicalStaffEntities;
    }

}
