package com.isa.blood_transfusion.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@DiscriminatorValue("SA")
@Entity(name = "scheduled_appointments")
public class ScheduledAppointmentEntity extends FreeAppointmentEntity {
    @ManyToOne
    @JoinColumn(name = "blood_donor_info_id")
    private BloodDonorInfoEntity bloodDonorInfo;
    @ManyToOne
    @JoinColumn(name = "registered_user_id")
    private RegisteredUserEntity registeredUser;
}
