package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.CanceledAppointmentEntity;
import com.isa.blood_transfusion.model.CanceledAppointment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class CanceledAppointmentConverter {
    private CenterConverter centerConverter;
    private RegisteredUserConverter registeredUserConverter;

    public CanceledAppointment toModel(CanceledAppointmentEntity canceledAppointmentEntity) {
        return new CanceledAppointment(canceledAppointmentEntity.getId(),
                centerConverter.toModel(canceledAppointmentEntity.getCenter()),
                canceledAppointmentEntity.getDate(),
                registeredUserConverter.toModel(canceledAppointmentEntity.getRegisteredUser()));
    }

    public Set<CanceledAppointment> toModel(Set<CanceledAppointmentEntity> canceledAppointmentEntities) {
        Set<CanceledAppointment> canceledAppointments = new HashSet<>();
        for (var c : canceledAppointmentEntities) {
            canceledAppointments.add(new CanceledAppointment(c.getId(),
                    centerConverter.toModel(c.getCenter()),
                    c.getDate(),
                    registeredUserConverter.toModel(c.getRegisteredUser())));
        }

        return canceledAppointments;
    }

    public CanceledAppointmentEntity toEntity(CanceledAppointment canceledAppointment) {
        return new CanceledAppointmentEntity(canceledAppointment.getId(),
                centerConverter.toEntity(canceledAppointment.getCenter()),
                canceledAppointment.getDate(),
                registeredUserConverter.toEntity(canceledAppointment.getRegisteredUser()));
    }

    public Set<CanceledAppointmentEntity> toEntity(Set<CanceledAppointment> canceledAppointments) {
        Set<CanceledAppointmentEntity> canceledAppointmentEntities = new HashSet<>();
        for (var c : canceledAppointments) {
            canceledAppointmentEntities.add(new CanceledAppointmentEntity(c.getId(),
                    centerConverter.toEntity(c.getCenter()),
                    c.getDate(),
                    registeredUserConverter.toEntity(c.getRegisteredUser())));
        }

        return canceledAppointmentEntities;
    }

}
