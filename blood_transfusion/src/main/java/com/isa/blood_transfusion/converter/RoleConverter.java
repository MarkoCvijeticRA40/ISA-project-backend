package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.RoleEntity;
import com.isa.blood_transfusion.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public Role toModel(RoleEntity roleEntity) {
        return new Role(roleEntity.getId(), roleEntity.getName());
    }
}
