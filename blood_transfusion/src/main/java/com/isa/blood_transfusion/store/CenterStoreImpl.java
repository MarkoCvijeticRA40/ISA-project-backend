package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.CenterConverter;
import com.isa.blood_transfusion.model.Center;
import com.isa.blood_transfusion.repository.CenterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CenterStoreImpl implements CenterStore{
    private final CenterRepository repository;
    private final CenterConverter converter;

    @Override
    public Center save(Center center) {
        repository.save(converter.toEntity(center));
        return center;
    }

    @Override
    public List<Center> findAll() {
        return converter.toModel(repository.findAll().stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public Center getById(Long id) {
        if (repository.getById(id) == null) {
            return null;
        } else {
            return converter.toModel(repository.getById(id));
        }
    }
}
