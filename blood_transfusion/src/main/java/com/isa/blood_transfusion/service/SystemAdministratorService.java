package com.isa.blood_transfusion.service;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.model.SystemAdministrator;


public interface SystemAdministratorService {
    SystemAdministrator find(String email);

    SystemAdministrator save(SystemAdministrator systemAdministrator);
}
