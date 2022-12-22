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
import com.isa.blood_transfusion.store.RoleStore;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class SystemAdministratorServiceImpl implements SystemAdministratorService {
    private final SystemAdministratorStore store;
    private final RoleStore roleStore;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SystemAdministrator find(String email) {
        return store.find(email);
    }

    @Override
    public SystemAdministrator findById(Long id) {
        return store.findById(id);
    }

    @Override
    public SystemAdministrator save(SystemAdministrator systemAdministrator) {
        systemAdministrator.setRole(roleStore.find("SYSTEM_ADMINISTRATOR"));
        systemAdministrator.setPassword(passwordEncoder.encode(systemAdministrator.getPassword()));
        return store.save(systemAdministrator);
    }

    @Override
    public SystemAdministrator savePassword(SystemAdministrator systemAdministrator) {
        systemAdministrator.setRole(roleStore.find("SYSTEM_ADMINISTRATOR"));
        systemAdministrator.setPassword(passwordEncoder.encode(systemAdministrator.getPassword()));
        return store.save(systemAdministrator);
    }
}
