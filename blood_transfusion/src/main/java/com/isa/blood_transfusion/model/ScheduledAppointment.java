package com.isa.blood_transfusion.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ScheduledAppointment extends FreeAppointment {
    private BloodDonorInfo bloodDonorInfo;
    private RegisteredUser registeredUser;

    public ScheduledAppointment(Long id, LocalDateTime date, Integer duration, Center center, MedicalStaff medicalStaff, BloodDonorInfo bloodDonorInfo, RegisteredUser registeredUser) {
        super(id, date, duration, center, medicalStaff);
        this.bloodDonorInfo = bloodDonorInfo;
        this.registeredUser = registeredUser;
    }
}
