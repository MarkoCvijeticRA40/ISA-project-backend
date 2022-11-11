package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.RegisteredUserConverter;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.repository.RegisteredUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisteredUserStoreImpl implements RegisteredUserStore {
    private final RegisteredUserRepository repository;
    private final RegisteredUserConverter converter;

    @Override
    public RegisteredUser findByEmail(String email) {
        return converter.toModel(repository.findByEmail(email));
    }
}
