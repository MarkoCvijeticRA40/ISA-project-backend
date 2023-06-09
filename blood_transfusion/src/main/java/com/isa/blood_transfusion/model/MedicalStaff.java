package com.isa.blood_transfusion.model;

import com.isa.blood_transfusion.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
public class MedicalStaff extends AppUser {
    public MedicalStaff(Long id, String email, String password, String name, String surname, String phoneNum, String identityNumber, String profession, String facilityInfo, Role role, Address address, Gender gender, boolean enabled, Timestamp lastPasswordResetDate) {
        super(id, email, password, name, surname, phoneNum, identityNumber, profession, facilityInfo, role, address, gender, enabled, lastPasswordResetDate);
    }
}
