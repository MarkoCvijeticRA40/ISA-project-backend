package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.AppUserConverter;
import com.isa.blood_transfusion.model.AppUser;
import com.isa.blood_transfusion.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class AppUserStoreImpl implements AppUserStore{
    private final AppUserRepository repository;
    private final AppUserConverter converter;

    @Override
    public AppUser save(AppUser appUser) {
        repository.save(converter.toEntity(appUser));
        return appUser;
    }

    @Override
    public AppUser find(String email) {
        return converter.toModel(repository.findByEmail(email));
    }

    @Override
    public List<AppUser> findAll() {
        return converter.toModel(repository.findAll().stream().collect(Collectors.toSet())).stream().toList();
    }
}
