package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.RoleEntity;
import com.isa.blood_transfusion.model.Role;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RoleConverter {

    public Role toModel(RoleEntity roleEntity) {
        return new Role(roleEntity.getId(), roleEntity.getName());
    }

    public Set<Role> toModel(Set<RoleEntity> roleEntities) {
        Set<Role> roles = new HashSet<>();
        for (var r : roleEntities) {
            roles.add(new Role(r.getId(), r.getName()));
        }

        return roles;
    }

    public RoleEntity toEntity(Role role) {
        return new RoleEntity(role.getId(), role.getName());
    }

    public Set<RoleEntity> toEntity(Set<Role> roles) {
        Set<RoleEntity> roleEntities = new HashSet<>();
        for (var r : roles) {
            roleEntities.add(new RoleEntity(r.getId(), r.getName()));
        }

        return roleEntities;
    }
}
