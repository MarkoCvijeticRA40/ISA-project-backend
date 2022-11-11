package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.CenterEntity;
import com.isa.blood_transfusion.model.Center;
import lombok.AllArgsConstructor;
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

    public CenterEntity toEntity(Center center) {
        return new CenterEntity(center.getId(),
                center.getName(),
                center.getDescription(),
                center.getAvgGrade(),
                addressConverter.toEntity(center.getAddress()),
                workTimeConverter.toEntity(center.getWorkTime()),
                bloodConverter.toEntity(center.getBlood()),
                equipmentConverter.toEntity(center.getEquipments()),
                freeAppointmentConverter.toEntity(center.getFreeAppointments()),
                medicalStaffConverter.toEntity(center.getMedicalStaff()));
    }

    public Set<CenterEntity> toEntity(Set<Center> centers) {
        Set<CenterEntity> centerEntities = new HashSet<>();
        for (var c : centers) {
            centerEntities.add(new CenterEntity(c.getId(),
                    c.getName(),
                    c.getDescription(),
                    c.getAvgGrade(),
                    addressConverter.toEntity(c.getAddress()),
                    workTimeConverter.toEntity(c.getWorkTime()),
                    bloodConverter.toEntity(c.getBlood()),
                    equipmentConverter.toEntity(c.getEquipments()),
                    freeAppointmentConverter.toEntity(c.getFreeAppointments()),
                    medicalStaffConverter.toEntity(c.getMedicalStaff())));
        }

        return centerEntities;
    }
}
