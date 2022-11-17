package com.isa.blood_transfusion.service;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.model.SystemAdministrator;
import com.isa.blood_transfusion.store.RegisteredUserStore;
import com.isa.blood_transfusion.store.RoleStore;
import com.isa.blood_transfusion.store.SystemAdministratorStore;
import com.isa.blood_transfusion.store.UserCategoryStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class SystemAdministratorServiceImpl implements SystemAdministratorService {
    private final SystemAdministratorStore store;

    @Override
    public SystemAdministrator find(String email) {
        return store.find(email);
    }

    @Override
    public SystemAdministrator save(SystemAdministrator systemAdministrator) {
        return store.save(systemAdministrator);
    }
}
