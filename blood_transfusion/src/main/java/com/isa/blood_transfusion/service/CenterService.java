package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.Center;

import java.util.List;

public interface CenterService {

    Center save(Center center);
    List<Center> findAll();
    Center getById(Long id);
    List<Center> getSortedByNameAsc();
    List<Center> getSortedByNameDesc();
    List<Center> getSortedByAvgGradeAsc();
    List<Center> getSortedByAvgGradeDesc();
}
