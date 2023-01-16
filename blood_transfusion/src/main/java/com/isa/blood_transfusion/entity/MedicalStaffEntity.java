package com.isa.blood_transfusion.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("MS")
@Entity
public class MedicalStaffEntity extends AppUserEntity {
    @Column(name = "points", nullable = false)
    private Integer points;
    @Column(name = "num_of_penalties", nullable = false)
    private Integer numOfPenalties;

    public MedicalStaffEntity(Long id, String email, String password, String name, String surname, String phoneNum, String identityNumber, String profession, String facilityInfo, RoleEntity role, AddressEntity address, Gender gender, boolean enabled, Timestamp lastPasswordResetDate) {
        super(id, email, password, name, surname, phoneNum, identityNumber, profession, facilityInfo, role, address, gender, enabled, lastPasswordResetDate);
        this.points = 0;
        this.numOfPenalties = 0;
    }
}