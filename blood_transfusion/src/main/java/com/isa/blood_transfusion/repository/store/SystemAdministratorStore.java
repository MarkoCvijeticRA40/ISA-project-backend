package com.isa.blood_transfusion.repository.store;

import com.isa.blood_transfusion.model.SystemAdministrator;

public interface SystemAdministratorStore {
    SystemAdministrator find(String email);

    SystemAdministrator findById(Long id);


    SystemAdministrator save(SystemAdministrator systemAdministrator);
}
