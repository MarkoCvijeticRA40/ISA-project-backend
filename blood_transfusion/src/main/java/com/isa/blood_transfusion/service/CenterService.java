package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.dto.CenterDto;
import com.isa.blood_transfusion.model.Center;
import java.time.LocalDateTime;
import java.util.List;

public interface CenterService {

    Center save(Center center);

    List<Center> findAll();

    Center getById(Long id);

    List<Center> search(String name, String place);

    List<Center> filter(String name, String place, Double gradeFrom, Double gradeTo);

    Center getCenterByMedicalStaffId(Long id);

    Center updateCenter(CenterDto centerDto, Long id);

    List<Center> getSortedByNameAsc();

    List<Center> getSortedByNameDesc();

    List<Center> getSortedByAvgGradeAsc();

    List<Center> getSortedByAvgGradeDesc();
    boolean IsCenterWorking(LocalDateTime appointmentDate,Long centerId);
    boolean IsCenterScheduled(LocalDateTime date, Long centerId);
    List<Center> GetAvailableCenters(LocalDateTime date);

}
