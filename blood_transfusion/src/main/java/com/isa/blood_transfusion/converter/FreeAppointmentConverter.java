package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.FreeAppointmentEntity;
import com.isa.blood_transfusion.model.FreeAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class FreeAppointmentConverter {
    private MedicalStaffConverter medicalStaffConverter;
    private CenterConverter centerConverter;

    @Autowired
    public FreeAppointmentConverter(@Lazy MedicalStaffConverter medicalStaffConverter, @Lazy CenterConverter centerConverter) {
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
        for (var r : freeAppointmentEntities) {
            freeAppointments.add(new FreeAppointment(r.getId(),
                r.getDate(),
                r.getDuration(),
                centerConverter.toModel(r.getCenter()),
                medicalStaffConverter.toModel(r.getMedicalStaff())));
        }
        return freeAppointments;
    }

    public List<FreeAppointment> toModel(List<FreeAppointmentEntity> freeAppointmentEntities) {
        List<FreeAppointment> freeAppointments = new ArrayList<>();
        for (var r : freeAppointmentEntities) {
            freeAppointments.add(new FreeAppointment(r.getId(),
                    r.getDate(),
                    r.getDuration(),
                    centerConverter.toModel(r.getCenter()),
                    medicalStaffConverter.toModel(r.getMedicalStaff())));
        }
        return freeAppointments;
    }

    public FreeAppointmentEntity toEntity(FreeAppointment freeAppointment) {
        return new FreeAppointmentEntity(freeAppointment.getId(),
                freeAppointment.getDate().plusHours(1),
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
