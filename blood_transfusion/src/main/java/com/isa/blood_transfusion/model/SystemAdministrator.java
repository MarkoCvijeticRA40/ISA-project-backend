package com.isa.blood_transfusion.model;

import com.isa.blood_transfusion.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class SystemAdministrator extends AppUser {

    @Getter
    @Setter
    private Boolean isFirstLogin;

    public SystemAdministrator(Long id, String email, String password, String name, String surname, String phoneNum, String identityNumber, String profession, String facilityInfo, Role role, Address address, Gender gender, boolean enabled, Timestamp lastPasswordResetDate, Boolean isFirstLogin) {
        super(id, email, password, name, surname, phoneNum, identityNumber, profession, facilityInfo, role, address, gender, enabled, lastPasswordResetDate);
        this.isFirstLogin = isFirstLogin;
    }

}
