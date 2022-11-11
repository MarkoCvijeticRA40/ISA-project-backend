package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.EquipmentEntity;
import com.isa.blood_transfusion.model.Equipment;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class EquipmentConverter {

    public Equipment toModel(EquipmentEntity equipmentEntity) {
        return new Equipment(equipmentEntity.getId(), equipmentEntity.getName(), equipmentEntity.getQuantity());
    }

    public Set<Equipment> toModel(Set<EquipmentEntity> equipmentEntities) {
        Set<Equipment> equipments = new HashSet<>();
        for (var e : equipmentEntities) {
            equipments.add(new Equipment(e.getId(), e.getName(), e.getQuantity()));
        }

        return equipments;
    }
}
