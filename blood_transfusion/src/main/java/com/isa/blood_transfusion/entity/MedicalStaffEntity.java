package com.isa.blood_transfusion.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("MS")
@Entity
public class MedicalStaffEntity extends AppUserEntity {

    public MedicalStaffEntity(Long id, String email, String password, String name, String surname, String phoneNum, String identityNumber, String profession, String facilityInfo, RoleEntity role, AddressEntity address, Gender gender) {
        super(id, email, password, name, surname, phoneNum, identityNumber, profession, facilityInfo, role, address, gender);
    }
}
