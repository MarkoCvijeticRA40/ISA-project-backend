package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.BloodDonorInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodDonorInfoRepository extends JpaRepository<BloodDonorInfoEntity, Long> {
    BloodDonorInfoEntity findBloodDonorInfoEntityByRegisteredUserId(Long id);
}
