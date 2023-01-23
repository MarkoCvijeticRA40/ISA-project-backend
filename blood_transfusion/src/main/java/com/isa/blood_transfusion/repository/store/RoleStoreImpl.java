package com.isa.blood_transfusion.repository.store;

import com.isa.blood_transfusion.converter.RoleConverter;
import com.isa.blood_transfusion.model.Role;
import com.isa.blood_transfusion.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RoleStoreImpl implements RoleStore {
    private final RoleRepository repository;
    private final RoleConverter converter;

    @Override
    public Role save(Role role) {
        repository.save(converter.toEntity(role));
        return role;
    }

    @Override
    public Role find(String name) {
        return converter.toModel(repository.findByName(name));
    }
}
