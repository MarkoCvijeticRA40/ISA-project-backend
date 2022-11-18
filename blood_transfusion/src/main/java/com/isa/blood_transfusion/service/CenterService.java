package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.dto.CenterDto;
import com.isa.blood_transfusion.dto.SearchInput;
import com.isa.blood_transfusion.model.Center;

import java.util.List;

public interface CenterService {
    List<Center> findAll();
    Center getById(Long id);
    List<Center> search(String name, String place);
    List<Center> filter(String name, String place, Double gradeFrom, Double gradeTo);
    Center getCenterByMedicalStaffId(Long id);
    Center updateCenter(CenterDto centerDto, Long id);
}
