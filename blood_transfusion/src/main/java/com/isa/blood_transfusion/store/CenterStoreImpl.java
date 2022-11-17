package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.CenterConverter;
import com.isa.blood_transfusion.dto.SearchCriteria;
import com.isa.blood_transfusion.dto.SearchInput;
import com.isa.blood_transfusion.dto.SearchParameter;
import com.isa.blood_transfusion.entity.CenterEntity;
import com.isa.blood_transfusion.model.Center;
import com.isa.blood_transfusion.repository.CenterRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CenterStoreImpl implements CenterStore{
    private final CenterRepository repository;
    private final CenterConverter converter;
    private final SessionFactory factory;

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
    public List<Center> searchByName(String name) {
        return converter.toModel(repository.findByNameContainingIgnoreCase(name).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> searchByPlace(String place) {
        return converter.toModel(repository.findByPlace(place).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> searchByNameAndPlace(String name, String place) {
        return converter.toModel(repository.findByNameAndPlace(name, place).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByGradeFrom(Double gradeFrom) {
        return converter.toModel(repository.findByGradeFrom(gradeFrom).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByGradeTo(Double gradeTo) {
        return converter.toModel(repository.findByGradeTo(gradeTo).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByGradeFromAndGradeTo(Double gradeFrom, Double gradeTo) {
        return converter.toModel(repository.findByGradeFromAndGradeTo(gradeFrom, gradeTo).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByNameAndGradeFrom(String name, Double gradeFrom) {
        return converter.toModel(repository.findByNameAndGradeFrom(name, gradeFrom).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByNameAndGradeFromAndGradeTo(String name, Double gradeFrom, Double gradeTo) {
        return converter.toModel(repository.findByNameAndGradeFromAndGradeTo(name, gradeFrom, gradeTo).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByNameAndGradeTo(String name, Double gradeTo) {
        return converter.toModel(repository.findByNameAndGradeTo(name, gradeTo).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByPlaceAndGradeFrom(String place, Double gradeFrom) {
        return converter.toModel(repository.findByPlaceAndGradeFrom(place, gradeFrom).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByPlaceAndGradeTo(String place, Double gradeTo) {
        return converter.toModel(repository.findByPlaceAndGradeTo(place, gradeTo).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByPlaceAndGradeFromAndGradeTo(String place, Double gradeFrom, Double gradeTo) {
        return converter.toModel(repository.findByPlaceAndGradeFromAndGradeTo(place, gradeFrom, gradeTo).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByNameAndPlaceAndGradeFrom(String name, String place, Double gradeFrom) {
        return converter.toModel(repository.findByNameAndPlaceAndGradeFrom(name, place, gradeFrom).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByNameAndPlaceAndGradeTo(String name, String place, Double gradeTo) {
        return converter.toModel(repository.findByNameAndPlaceAndGradeTo(name, place, gradeTo).stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public List<Center> filterByNameAndPlaceAndGradeFromAndGradeTo(String name, String place, Double gradeFrom, Double gradeTo) {
        return converter.toModel(repository.findByNameAndPlaceAndGradeFromAndGradeTo(name, place, gradeFrom, gradeTo).stream().collect(Collectors.toSet())).stream().toList();
    }
}
