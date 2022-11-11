package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.BloodEntity;
import com.isa.blood_transfusion.model.Blood;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BloodConverter {

    public Blood toModel(BloodEntity bloodEntity) {
        return new Blood(bloodEntity.getId(), bloodEntity.getQuantityInLiters(), bloodEntity.getBloodType());
    }

    public Set<Blood> toModel(Set<BloodEntity> bloodEntities) {
        Set<Blood> blood = new HashSet<>();
        for (var b : bloodEntities) {
            blood.add(new Blood(b.getId(), b.getQuantityInLiters(), b.getBloodType()));
        }

        return blood;
    }

    public BloodEntity toEntity(Blood blood) {
        return new BloodEntity(blood.getId(), blood.getQuantityInLiters(), blood.getBloodType());
    }

    public Set<BloodEntity> toEntity(Set<Blood> blood) {
        Set<BloodEntity> bloodEntities = new HashSet<>();
        for (var b : blood) {
            bloodEntities.add(new BloodEntity(b.getId(), b.getQuantityInLiters(), b.getBloodType()));
        }

        return bloodEntities;
    }
}
