package com.isa.blood_transfusion.repository;


import com.isa.blood_transfusion.entity.CenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CenterRepository extends JpaRepository<CenterEntity, Long> {
    default CenterEntity getById(Long id) {
        return findById(id).orElse(null);
    }

    List<CenterEntity> findByNameContainingIgnoreCase(String name);

    @Query(value = "select * from centers c inner join addresses a on c.address_id = a.id " +
            "where lower(a.city) like lower(concat('%', ?1,'%')) or lower(a.street) like lower(concat('%', ?1,'%')) " +
            "or lower(a.state) like lower(concat('%', ?1,'%'))", nativeQuery = true)
    List<CenterEntity> findByPlace(String place);

    @Query(value = "select * from centers c inner join addresses a on c.address_id = a.id " +
            "where lower(c.name) like lower(concat('%', ?1,'%')) or lower(a.city) like lower(concat('%', ?2,'%')) " +
            "or lower(a.street) like lower(concat('%', ?2,'%')) or lower(a.state) like lower(concat('%', ?2,'%'))", nativeQuery = true)
    List<CenterEntity> findByNameAndPlace(String name, String place);

    @Query(value = "select * from centers c where c.average_grade >= ?1", nativeQuery = true)
    List<CenterEntity> findByGradeFrom(Double gradeFrom);

    @Query(value = "select * from centers c where c.average_grade <= ?1", nativeQuery = true)
    List<CenterEntity> findByGradeTo(Double gradeTo);

    @Query(value = "select * from centers c where c.average_grade >= ?1 and c.average_grade <= ?2", nativeQuery = true)
    List<CenterEntity> findByGradeFromAndGradeTo(Double gradeFrom, Double gradeTo);

    @Query(value = "select * from centers c where lower(c.name) like lower(concat('%', ?1,'%')) and c.average_grade >= ?2", nativeQuery = true)
    List<CenterEntity> findByNameAndGradeFrom(String name, Double gradeFrom);

    @Query(value = "select * from centers c where lower(c.name) like lower(concat('%', ?1,'%')) and c.average_grade >= ?2 and c.average_grade <= ?3", nativeQuery = true)
    List<CenterEntity> findByNameAndGradeFromAndGradeTo(String name, Double gradeFrom, Double gradeTo);

    @Query(value = "select * from centers c where lower(c.name) like lower(concat('%', ?1,'%')) and c.average_grade <= ?2", nativeQuery = true)
    List<CenterEntity> findByNameAndGradeTo(String name, Double gradeTo);

    @Query(value = "select * from centers c inner join addresses a on c.address_id = a.id where (lower(a.city) like lower(concat('%', ?1,'%')) " +
            "or lower(a.street) like lower(concat('%', ?1,'%')) or lower(a.state) like lower(concat('%', ?1,'%'))) and c.average_grade >= ?2", nativeQuery = true)
    List<CenterEntity> findByPlaceAndGradeFrom(String place, Double gradeFrom);

    @Query(value = "select * from centers c inner join addresses a on c.address_id = a.id where (lower(a.city) like lower(concat('%', ?1,'%')) " +
            "or lower(a.street) like lower(concat('%', ?1,'%')) or lower(a.state) like lower(concat('%', ?1,'%'))) and c.average_grade <= ?2", nativeQuery = true)
    List<CenterEntity> findByPlaceAndGradeTo(String place, Double gradeTo);

    @Query(value = "select * from centers c inner join addresses a on c.address_id = a.id where (lower(a.city) like lower(concat('%', ?1,'%')) " +
            "or lower(a.street) like lower(concat('%', ?1,'%')) or lower(a.state) like lower(concat('%', ?1,'%'))) and c.average_grade >= ?2 and c.average_grade <= ?3", nativeQuery = true)
    List<CenterEntity> findByPlaceAndGradeFromAndGradeTo(String place, Double gradeFrom, Double gradeTo);

    @Query(value = "select * from centers c inner join addresses a on c.address_id = a.id where (lower(c.name) like lower(concat('%', ?1,'%')) or lower(a.city) like lower(concat('%', ?2,'%')) " +
            "or lower(a.street) like lower(concat('%', ?2,'%')) or lower(a.state) like lower(concat('%', ?2,'%'))) and c.average_grade >= ?3", nativeQuery = true)
    List<CenterEntity> findByNameAndPlaceAndGradeFrom(String name, String place, Double gradeFrom);

    @Query(value = "select * from centers c inner join addresses a on c.address_id = a.id where (lower(c.name) like lower(concat('%', ?1,'%')) or lower(a.city) like lower(concat('%', ?2,'%')) " +
            "or lower(a.street) like lower(concat('%', ?2,'%')) or lower(a.state) like lower(concat('%', ?2,'%'))) and c.average_grade <= ?3", nativeQuery = true)
    List<CenterEntity> findByNameAndPlaceAndGradeTo(String name, String place, Double gradeTo);

    @Query(value = "select * from centers c inner join addresses a on c.address_id = a.id where (lower(c.name) like lower(concat('%', ?1,'%')) or lower(a.city) like lower(concat('%', ?2,'%')) " +
            "or lower(a.street) like lower(concat('%', ?2,'%')) or lower(a.state) like lower(concat('%', ?2,'%'))) and c.average_grade >= ?3 and c.average_grade <= 4", nativeQuery = true)
    List<CenterEntity> findByNameAndPlaceAndGradeFromAndGradeTo(String name, String place, Double gradeFrom, Double gradeTo);

    @Query(value = "select c.* from centers c inner join users u on u.center_id = c.id where u.id = ?1", nativeQuery = true)
    CenterEntity findCenterByMedicalStaffId(Long id);

    default CenterEntity getByName(Long id) {
        return findById(id).orElse(null);
    }

    List<CenterEntity> findByOrderByNameAsc();

    List<CenterEntity> findByOrderByNameDesc();

    List<CenterEntity> findByOrderByAvgGradeAsc();

    List<CenterEntity> findByOrderByAvgGradeDesc();

}