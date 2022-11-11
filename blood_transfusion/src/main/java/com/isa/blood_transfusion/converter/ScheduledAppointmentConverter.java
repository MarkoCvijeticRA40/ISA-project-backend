package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.ScheduledAppointmentEntity;
import com.isa.blood_transfusion.model.ScheduledAppointment;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ScheduledAppointmentConverter {
    private MedicalStaffConverter medicalStaffConverter;
    private CenterConverter centerConverter;
    private BloodDonorInfoConverter bloodDonorInfoConverter;
    private RegisteredUserConverter registeredUserConverter;

    @Autowired
    public ScheduledAppointmentConverter(MedicalStaffConverter medicalStaffConverter, CenterConverter centerConverter, BloodDonorInfoConverter bloodDonorInfoConverter, @Lazy RegisteredUserConverter registeredUserConverter) {
        this.medicalStaffConverter = medicalStaffConverter;
        this.centerConverter = centerConverter;
        this.bloodDonorInfoConverter = bloodDonorInfoConverter;
        this.registeredUserConverter = registeredUserConverter;
    }

    public ScheduledAppointment toModel(ScheduledAppointmentEntity scheduledAppointmentEntity) {
        return new ScheduledAppointment(scheduledAppointmentEntity.getId(),
                scheduledAppointmentEntity.getDate(),
                scheduledAppointmentEntity.getDuration(),
                centerConverter.toModel(scheduledAppointmentEntity.getCenter()),
                medicalStaffConverter.toModel(scheduledAppointmentEntity.getMedicalStaff()),
                bloodDonorInfoConverter.toModel(scheduledAppointmentEntity.getBloodDonorInfo()),
                registeredUserConverter.toModel(scheduledAppointmentEntity.getRegisteredUser())
        );
    }

    public Set<ScheduledAppointment> toModel(Set<ScheduledAppointmentEntity> scheduledAppointmentEntities) {
        Set<ScheduledAppointment> scheduledAppointments = new HashSet<>();
        for (var s : scheduledAppointmentEntities) {
            scheduledAppointments.add(new ScheduledAppointment(s.getId(),
                    s.getDate(),
                    s.getDuration(),
                    centerConverter.toModel(s.getCenter()),
                    medicalStaffConverter.toModel(s.getMedicalStaff()),
                    bloodDonorInfoConverter.toModel(s.getBloodDonorInfo()),
                    registeredUserConverter.toModel(s.getRegisteredUser())));
        }

        return scheduledAppointments;
    }
}
