package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.dto.SearchInput;
import com.isa.blood_transfusion.model.Center;

import java.util.List;

public interface CenterStore {
    List<Center> findAll();
    Center getById(Long id);
    List<Center> searchByName(String name);
    List<Center> searchByPlace(String place);
    List<Center> searchByNameAndPlace(String name, String place);
    List<Center> filterByGradeFrom(Double gradeFrom);
    List<Center> filterByGradeTo(Double gradeTo);
    List<Center> filterByGradeFromAndGradeTo(Double gradeFrom, Double gradeTo);
    List<Center> filterByNameAndGradeFrom(String name, Double gradeFrom);
    List<Center> filterByNameAndGradeFromAndGradeTo(String name, Double gradeFrom, Double gradeTo);
    List<Center> filterByNameAndGradeTo(String name, Double gradeTo);
    List<Center> filterByPlaceAndGradeFrom(String place, Double gradeFrom);
    List<Center> filterByPlaceAndGradeTo(String place, Double gradeTo);
    List<Center> filterByPlaceAndGradeFromAndGradeTo(String place, Double gradeFrom, Double gradeTo);
    List<Center> filterByNameAndPlaceAndGradeFrom(String name, String place, Double gradeFrom);
    List<Center> filterByNameAndPlaceAndGradeTo(String name, String place, Double gradeTo);
    List<Center> filterByNameAndPlaceAndGradeFromAndGradeTo(String name, String place, Double gradeFrom, Double gradeTo);

}
