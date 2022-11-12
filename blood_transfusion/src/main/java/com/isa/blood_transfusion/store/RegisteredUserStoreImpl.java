package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.RegisteredUserConverter;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.repository.RegisteredUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RegisteredUserStoreImpl implements RegisteredUserStore {
    private final RegisteredUserRepository repository;
    private final RegisteredUserConverter converter;

    @Override
    public RegisteredUser save(RegisteredUser user) {
        repository.save(converter.toEntity(user));
        return user;
    }

    @Override
    public List<RegisteredUser> findAll() {
        return converter.toModel(repository.findAll().stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<RegisteredUser> findAll(Pageable pageable) {
        return converter.toModel(repository.findAll(pageable).toSet()).stream().toList();
    }
}
