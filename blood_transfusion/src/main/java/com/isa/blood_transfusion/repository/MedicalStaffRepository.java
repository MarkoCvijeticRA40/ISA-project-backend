package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.CenterEntity;
import com.isa.blood_transfusion.entity.MedicalStaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MedicalStaffRepository extends JpaRepository<MedicalStaffEntity, Long> {
    default MedicalStaffEntity getById(Long id) { return findById(id).orElse(null); }
}
