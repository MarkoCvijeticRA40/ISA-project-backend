package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.SystemAdministrator;


public interface SystemAdministratorService {
    SystemAdministrator find(String email);

    SystemAdministrator findById(Long id);

    SystemAdministrator save(SystemAdministrator systemAdministrator);

    SystemAdministrator savePassword(SystemAdministrator systemAdministrator);
}
