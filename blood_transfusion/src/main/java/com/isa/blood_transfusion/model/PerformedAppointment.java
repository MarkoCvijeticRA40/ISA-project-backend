package com.isa.blood_transfusion.model;

import com.isa.blood_transfusion.entity.BloodDonorInfoEntity;
import com.isa.blood_transfusion.entity.RegisteredUserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PerformedAppointment extends FreeAppointment {
    private BloodDonorInfo bloodDonorInfo;
    private RegisteredUser registeredUser;
    private String info;

    public PerformedAppointment(Long id, LocalDateTime date, Integer duration, Center center, MedicalStaff medicalStaff, BloodDonorInfo bloodDonorInfo, RegisteredUser registeredUser, String info) {
        super(id, date, duration, center, medicalStaff);
        this.bloodDonorInfo = bloodDonorInfo;
        this.registeredUser = registeredUser;
        this.info = info;
    }
}
