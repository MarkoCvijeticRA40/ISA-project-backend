package com.isa.blood_transfusion.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Timestamp;

@DiscriminatorValue("SA")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class SystemAdministratorEntity extends AppUserEntity {
    @Column(name = "points", nullable = false)
    private Integer points;
    @Column(name = "num_of_penalties", nullable = false)
    private Integer numOfPenalties;


    @Column(name = "is_first_login")
    @Getter
    @Setter
    private Boolean isFirstLogin;


    public SystemAdministratorEntity(Long id, String email, String password, String name, String surname, String phoneNum, String identityNumber, String profession, String facilityInfo, RoleEntity role, AddressEntity address, Gender gender, boolean enabled, Timestamp lastPasswordResetDate, Boolean isFirstLogin) {
        super(id, email, password, name, surname, phoneNum, identityNumber, profession, facilityInfo, role, address, gender, enabled, lastPasswordResetDate);
        this.points = 0;
        this.numOfPenalties = 0;
        this.isFirstLogin = isFirstLogin;

    }


}
