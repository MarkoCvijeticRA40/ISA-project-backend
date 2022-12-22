package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.Role;

public interface RoleService {
    Role save(Role role);

    Role find(String name);
}
