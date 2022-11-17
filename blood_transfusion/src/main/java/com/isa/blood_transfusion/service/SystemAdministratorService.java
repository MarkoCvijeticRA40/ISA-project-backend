package com.isa.blood_transfusion.service;
import com.isa.blood_transfusion.model.SystemAdministrator;


public interface SystemAdministratorService {
    SystemAdministrator find(String email);
}
