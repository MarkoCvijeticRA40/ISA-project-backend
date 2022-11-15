package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.FreeAppointmentEntity;
import com.isa.blood_transfusion.model.FreeAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class FreeAppointmentConverter {
    private MedicalStaffConverter medicalStaffConverter;
    private CenterConverter centerConverter;

    @Autowired
    public FreeAppointmentConverter(MedicalStaffConverter medicalStaffConverter, @Lazy CenterConverter centerConverter) {
        this.medicalStaffConverter = medicalStaffConverter;
        this.centerConverter = centerConverter;
    }

    public FreeAppointment toModel(FreeAppointmentEntity freeAppointmentEntity) {
        return new FreeAppointment(freeAppointmentEntity.getId(),
                freeAppointmentEntity.getDate(),
                freeAppointmentEntity.getDuration(),
                centerConverter.toModel(freeAppointmentEntity.getCenter()),
                medicalStaffConverter.toModel(freeAppointmentEntity.getMedicalStaff()));
    }

    public Set<FreeAppointment> toModel(Set<FreeAppointmentEntity> freeAppointmentEntities) {
        Set<FreeAppointment> freeAppointments = new HashSet<>();
        for (var f : freeAppointmentEntities) {
            freeAppointments.add(new FreeAppointment(f.getId(),
                    f.getDate(),
                    f.getDuration(),
                    centerConverter.toModel(f.getCenter()),
                    medicalStaffConverter.toModel(f.getMedicalStaff())));
        }

        return freeAppointments;
    }

    public FreeAppointmentEntity toEntity(FreeAppointment freeAppointment) {
        return new FreeAppointmentEntity(freeAppointment.getId(),
                freeAppointment.getDate(),
                freeAppointment.getDuration(),
                centerConverter.toEntity(freeAppointment.getCenter()),
                medicalStaffConverter.toEntity(freeAppointment.getMedicalStaff()));
    }

    public Set<FreeAppointmentEntity> toEntity(Set<FreeAppointment> freeAppointments) {
        Set<FreeAppointmentEntity> freeAppointmentEntities = new HashSet<>();
        for (var f : freeAppointments) {
            freeAppointmentEntities.add(new FreeAppointmentEntity(f.getId(),
                    f.getDate(),
                    f.getDuration(),
                    centerConverter.toEntity(f.getCenter()),
                    medicalStaffConverter.toEntity(f.getMedicalStaff())));
        }

        return freeAppointmentEntities;
    }
}
