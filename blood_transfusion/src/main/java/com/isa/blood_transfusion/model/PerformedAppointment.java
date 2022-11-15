package com.isa.blood_transfusion.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PerformedAppointment extends ScheduledAppointment {
    private String info;

    public PerformedAppointment(Long id, LocalDateTime date, Integer duration, Center center, MedicalStaff medicalStaff, BloodDonorInfo bloodDonorInfo, RegisteredUser registeredUser, String info) {
        super(id, date, duration, center, medicalStaff, bloodDonorInfo, registeredUser);
        this.info = info;
    }
}
