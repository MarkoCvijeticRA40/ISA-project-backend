package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.dto.CenterDto;
import com.isa.blood_transfusion.model.Address;
import com.isa.blood_transfusion.model.Center;
import com.isa.blood_transfusion.model.WorkTime;
import com.isa.blood_transfusion.store.CenterStore;
import com.isa.blood_transfusion.store.MedicalStaffStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class CenterServiceImpl implements CenterService {
    private final CenterStore store;
    private final MedicalStaffStore msStore;

    @Override
    public Center save(Center center) {


        return store.save(center);
    }

    @Override
    public List<Center> findAll() {
        return store.findAll();
    }

    @Override
    public Center getById(Long id) {
        return store.getById(id);
    }

    @Override
    public List<Center> search(String name, String place) {
        if (name != "" && place == "") {
            return store.searchByName(name);
        } else if (name == "" && place != "") {
            return store.searchByPlace(place);
        } else if (name != "" && place != "") {
            return store.searchByNameAndPlace(name, place);
        }
        return store.findAll();
    }

    @Override
    public List<Center> filter(String name, String place, Double gradeFrom, Double gradeTo) {
        if (name == "" && place == "" && gradeFrom != 0 && gradeTo == 0) {
            return store.filterByGradeFrom(gradeFrom);
        } else if (name == "" && place == "" && gradeFrom == 0 && gradeTo != 0) {
            return store.filterByGradeTo(gradeTo);
        } else if (name == "" && place == "" && gradeFrom != 0 && gradeTo != 0) {
            return store.filterByGradeFromAndGradeTo(gradeFrom, gradeTo);
        } else if (name != "" && place == "" && gradeFrom != 0 && gradeTo == 0) {
            return store.filterByNameAndGradeFrom(name, gradeFrom);
        } else if (name != "" && place == "" && gradeFrom != 0 && gradeTo != 0) {
            return store.filterByNameAndGradeFromAndGradeTo(name, gradeFrom, gradeTo);
        } else if (name != "" && place == "" && gradeFrom == 0 && gradeTo != 0) {
            return store.filterByNameAndGradeTo(name, gradeTo);
        } else if (name == "" && place != "" && gradeFrom != 0 && gradeTo == 0) {
            return store.filterByPlaceAndGradeFrom(place, gradeFrom);
        } else if (name == "" && place != "" && gradeFrom == 0 && gradeTo != 0) {
            return store.filterByPlaceAndGradeTo(place, gradeTo);
        } else if (name == "" && place != "" && gradeFrom != 0 && gradeTo != 0) {
            return store.filterByPlaceAndGradeFromAndGradeTo(place, gradeFrom, gradeTo);
        } else if (name != "" && place != "" && gradeFrom != 0 && gradeTo == 0) {
            return store.filterByNameAndPlaceAndGradeFrom(name, place, gradeFrom);
        } else if (name != "" && place != "" && gradeFrom == 0 && gradeTo != 0) {
            return store.filterByNameAndPlaceAndGradeTo(name, place, gradeTo);
        } else if (name != "" && place != "" && gradeFrom != 0 && gradeTo != 0) {
            return store.filterByNameAndPlaceAndGradeFromAndGradeTo(name, place, gradeFrom, gradeTo);
        }
        return search(name, place);
    }

    @Override
    public Center getCenterByMedicalStaffId(Long id) {
        return store.getCenterByMedicalStaffId(id);
    }

    @Override
    public Center updateCenter(CenterDto centerDto, Long id) {
        Center center = new Center(centerDto.getId(), centerDto.getName(), centerDto.getDescription(), centerDto.getAvgGrade(),
                new Address(centerDto.getAddress().getId(), centerDto.getAddress().getStreet(), centerDto.getAddress().getNumber(), centerDto.getAddress().getCity(), centerDto.getAddress().getState(), centerDto.getAddress().getLongitude(), centerDto.getAddress().getLatitude()),
                new WorkTime(centerDto.getWorkTime().getId(), LocalTime.parse(centerDto.getWorkTime().getStartTime()), LocalTime.parse(centerDto.getWorkTime().getEndTime())),
                centerDto.getBlood(), centerDto.getEquipments(), centerDto.getMedicalStaff());
        return store.updateCenter(center, id);
    }

    @Override
    public List<Center> getSortedByNameAsc() {
        return store.getSortedByNameAsc();
    }

    @Override
    public List<Center> getSortedByNameDesc() {
        return store.getSortedByNameDesc();
    }

    @Override
    public List<Center> getSortedByAvgGradeAsc() {
        return store.getSortedByAvgGradeAsc();
    }

    @Override
    public List<Center> getSortedByAvgGradeDesc() {
        return store.getSortedByAvgGradeDesc();
    }
}
