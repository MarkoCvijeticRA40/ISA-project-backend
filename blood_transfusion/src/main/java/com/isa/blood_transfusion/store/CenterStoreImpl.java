package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.CenterConverter;
import com.isa.blood_transfusion.entity.CenterEntity;
import com.isa.blood_transfusion.model.Center;
import com.isa.blood_transfusion.repository.CenterRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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

    @Override
    public List<Center> getSortedByNameAsc() {
        return converter.toModel(repository.findByOrderByNameAsc());
    }

    @Override
    public List<Center> getSortedByNameDesc() {
        return converter.toModel(repository.findByOrderByNameDesc());
    }

    @Override
    public List<Center> getSortedByAvgGradeAsc() {
        return converter.toModel(repository.findByOrderByAvgGradeAsc());
    }

    @Override
    public List<Center> getSortedByAvgGradeDesc() {
        return converter.toModel(repository.findByOrderByAvgGradeDesc());
    }

}
