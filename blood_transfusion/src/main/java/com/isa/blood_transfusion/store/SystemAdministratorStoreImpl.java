package com.isa.blood_transfusion.store;
import com.isa.blood_transfusion.converter.RegisteredUserConverter;
import com.isa.blood_transfusion.converter.SystemAdministratorConverter;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.model.SystemAdministrator;
import com.isa.blood_transfusion.repository.RegisteredUserRepository;
import com.isa.blood_transfusion.repository.SystemAdministratorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SystemAdministratorStoreImpl implements SystemAdministratorStore {
    private final SystemAdministratorRepository repository;
    private final SystemAdministratorConverter converter;

    @Override
    public SystemAdministrator find(String email) {
        return converter.toModel(repository.findByEmail(email));
    }

    @Override
    public SystemAdministrator findById(Long id) {
        if (repository.getById(id) == null) {
            return null;
        } else {
            return converter.toModel(repository.getById(id));
        }
    }

    @Override
    public SystemAdministrator save(SystemAdministrator systemAdministrator) {
        repository.save(converter.toEntity(systemAdministrator));
        return systemAdministrator;
    }
}
