package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.PerformedAppointmentEntity;
import com.isa.blood_transfusion.model.PerformedAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PerformedAppointmentConverter {
    private MedicalStaffConverter medicalStaffConverter;
    private CenterConverter centerConverter;
    private BloodDonorInfoConverter bloodDonorInfoConverter;
    private RegisteredUserConverter registeredUserConverter;

    @Autowired
    public PerformedAppointmentConverter(MedicalStaffConverter medicalStaffConverter, CenterConverter centerConverter, BloodDonorInfoConverter bloodDonorInfoConverter, @Lazy RegisteredUserConverter registeredUserConverter) {
        this.medicalStaffConverter = medicalStaffConverter;
        this.centerConverter = centerConverter;
        this.bloodDonorInfoConverter = bloodDonorInfoConverter;
        this.registeredUserConverter = registeredUserConverter;
    }

    public PerformedAppointment toModel(PerformedAppointmentEntity performedAppointmentEntity) {
        return new PerformedAppointment(performedAppointmentEntity.getId(),
                performedAppointmentEntity.getDate(),
                performedAppointmentEntity.getDuration(),
                centerConverter.toModel(performedAppointmentEntity.getCenter()),
                medicalStaffConverter.toModel(performedAppointmentEntity.getMedicalStaff()),
                bloodDonorInfoConverter.toModel(performedAppointmentEntity.getBloodDonorInfo()),
                registeredUserConverter.toModel(performedAppointmentEntity.getRegisteredUser()),
                performedAppointmentEntity.getInfo()
        );
    }

    public Set<PerformedAppointment> toModel(Set<PerformedAppointmentEntity> performedAppointmentEntities) {
        Set<PerformedAppointment> performedAppointments = new HashSet<>();
        for (var p : performedAppointmentEntities) {
            performedAppointments.add(new PerformedAppointment(p.getId(),
                    p.getDate(),
                    p.getDuration(),
                    centerConverter.toModel(p.getCenter()),
                    medicalStaffConverter.toModel(p.getMedicalStaff()),
                    bloodDonorInfoConverter.toModel(p.getBloodDonorInfo()),
                    registeredUserConverter.toModel(p.getRegisteredUser()),
                    p.getInfo()));
        }

        return performedAppointments;
    }

    public PerformedAppointmentEntity toEntity(PerformedAppointment performedAppointment) {
        return new PerformedAppointmentEntity(performedAppointment.getId(),
                performedAppointment.getDate(),
                performedAppointment.getDuration(),
                centerConverter.toEntity(performedAppointment.getCenter()),
                medicalStaffConverter.toEntity(performedAppointment.getMedicalStaff()),
                bloodDonorInfoConverter.toEntity(performedAppointment.getBloodDonorInfo()),
                registeredUserConverter.toEntity(performedAppointment.getRegisteredUser()),
                performedAppointment.getInfo()
        );
    }

    public Set<PerformedAppointmentEntity> toEntity(Set<PerformedAppointment> performedAppointments) {
        Set<PerformedAppointmentEntity> performedAppointmentEntities = new HashSet<>();
        for (var p : performedAppointments) {
            performedAppointmentEntities.add(new PerformedAppointmentEntity(p.getId(),
                    p.getDate(),
                    p.getDuration(),
                    centerConverter.toEntity(p.getCenter()),
                    medicalStaffConverter.toEntity(p.getMedicalStaff()),
                    bloodDonorInfoConverter.toEntity(p.getBloodDonorInfo()),
                    registeredUserConverter.toEntity(p.getRegisteredUser()),
                    p.getInfo()));
        }

        return performedAppointmentEntities;
    }
}
