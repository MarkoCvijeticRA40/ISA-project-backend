package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.UserCategoryConverter;
import com.isa.blood_transfusion.model.UserCategory;
import com.isa.blood_transfusion.repository.UserCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserCategoryStoreImpl implements UserCategoryStore {
    private final UserCategoryRepository repository;
    private final UserCategoryConverter converter;

    @Override
    public UserCategory save(UserCategory userCategory) {
        repository.save(converter.toEntity(userCategory));
        return userCategory;
    }

    @Override
    public UserCategory find(String name) {
        return converter.toModel(repository.findByName(name));
    }
}
