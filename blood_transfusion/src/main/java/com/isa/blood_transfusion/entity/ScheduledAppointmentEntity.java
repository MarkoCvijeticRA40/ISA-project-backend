package com.isa.blood_transfusion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("SA")
@Entity(name = "scheduled_appointments")
public class ScheduledAppointmentEntity extends FreeAppointmentEntity {
    @ManyToOne
    @JoinColumn(name = "blood_donor_info_id")
    private BloodDonorInfoEntity bloodDonorInfo;
    @ManyToOne
    @JoinColumn(name = "registered_user_id")
    private RegisteredUserEntity registeredUser;

    public ScheduledAppointmentEntity(Long id, LocalDateTime date, Integer duration, CenterEntity centerEntity, MedicalStaffEntity medicalStaffEntity, BloodDonorInfoEntity bloodDonorInfoEntity, RegisteredUserEntity registeredUserEntity) {
        super(id, date, duration, centerEntity, medicalStaffEntity);
        this.bloodDonorInfo = bloodDonorInfoEntity;
        this.registeredUser = registeredUserEntity;
    }
}
