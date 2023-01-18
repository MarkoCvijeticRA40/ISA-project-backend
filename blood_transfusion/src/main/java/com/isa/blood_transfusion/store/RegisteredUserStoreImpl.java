package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.RegisteredUserConverter;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.repository.RegisteredUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
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


    @Override
    public RegisteredUser update(RegisteredUser registeredUser) {
        repository.save(converter.toEntity(registeredUser));
        return registeredUser;
    }

    @Override
    public List<RegisteredUser> getByNameAndSurname(String name, String surname, Pageable pageable) {
        return converter.toModel(repository.findByNameAndSurname(name, surname, pageable).toSet()).stream().toList();
    }

    @Override
    public RegisteredUser find(String email) {
        return converter.toModel(repository.findByEmail(email));
    }


}
