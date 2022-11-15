package com.isa.blood_transfusion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PA")
@Entity
public class PerformedAppointmentEntity extends ScheduledAppointmentEntity {
    @Column(name = "info", nullable = false)
    private String info;

    public PerformedAppointmentEntity(Long id, LocalDateTime date, Integer duration, CenterEntity centerEntity, MedicalStaffEntity medicalStaffEntity, BloodDonorInfoEntity bloodDonorInfoEntity, RegisteredUserEntity registeredUserEntity, String info) {
        super(id, date, duration, centerEntity, medicalStaffEntity, bloodDonorInfoEntity, registeredUserEntity);
        this.info = info;
    }
}
