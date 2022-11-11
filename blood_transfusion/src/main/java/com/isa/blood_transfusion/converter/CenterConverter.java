package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.CenterEntity;
import com.isa.blood_transfusion.model.Center;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class CenterConverter {
    private EquipmentConverter equipmentConverter;
    private FreeAppointmentConverter freeAppointmentConverter;
    private MedicalStaffConverter medicalStaffConverter;
    private WorkTimeConverter workTimeConverter;
    private AddressConverter addressConverter;
    private BloodConverter bloodConverter;


    public Center toModel(CenterEntity centerEntity) {
        return new Center(centerEntity.getId(),
                centerEntity.getName(),
                centerEntity.getDescription(),
                centerEntity.getAvgGrade(),
                addressConverter.toModel(centerEntity.getAddress()),
                workTimeConverter.toModel(centerEntity.getWorkTime()),
                bloodConverter.toModel(centerEntity.getBlood()),
                equipmentConverter.toModel(centerEntity.getEquipments()),
                freeAppointmentConverter.toModel(centerEntity.getFreeAppointments()),
                medicalStaffConverter.toModel(centerEntity.getMedicalStaff()));
    }


    public Set<Center> toModel(Set<CenterEntity> centerEntities) {
        Set<Center> centers = new HashSet<>();
        for (var c : centerEntities) {
            centers.add(new Center(c.getId(),
                    c.getName(),
                    c.getDescription(),
                    c.getAvgGrade(),
                    addressConverter.toModel(c.getAddress()),
                    workTimeConverter.toModel(c.getWorkTime()),
                    bloodConverter.toModel(c.getBlood()),
                    equipmentConverter.toModel(c.getEquipments()),
                    freeAppointmentConverter.toModel(c.getFreeAppointments()),
                    medicalStaffConverter.toModel(c.getMedicalStaff())));
        }

        return centers;
    }
}
