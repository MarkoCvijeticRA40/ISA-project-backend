package com.isa.blood_transfusion.repository;


import com.isa.blood_transfusion.entity.CenterEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CenterRepository extends JpaRepository<CenterEntity, Long> {
    default CenterEntity getById(Long id) { return findById(id).orElse(null); }

    default CenterEntity getByName(Long id) { return findById(id).orElse(null); }

    List<CenterEntity> findByOrderByNameAsc();
    List<CenterEntity> findByOrderByNameDesc();
    List<CenterEntity> findByOrderByAvgGradeAsc();
    List<CenterEntity> findByOrderByAvgGradeDesc();

}
