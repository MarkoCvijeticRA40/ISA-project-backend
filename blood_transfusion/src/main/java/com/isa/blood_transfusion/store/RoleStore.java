package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.Role;

public interface RoleStore {
    Role save(Role role);

    Role find(String name);
}
