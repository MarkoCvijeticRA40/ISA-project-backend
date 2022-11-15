package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.Role;
import com.isa.blood_transfusion.store.RoleStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleStore store;

    @Override
    public Role save(Role role) {
        return store.save(role);
    }

    @Override
    public Role find(String name) {
        return store.find(name);
    }
}
