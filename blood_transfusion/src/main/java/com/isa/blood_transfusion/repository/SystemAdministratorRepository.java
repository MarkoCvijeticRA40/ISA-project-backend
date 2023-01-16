package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.SystemAdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemAdministratorRepository extends JpaRepository<SystemAdministratorEntity, Long> {
    SystemAdministratorEntity findByEmail(String email);

    default SystemAdministratorEntity getById(Long id) {
        return findById(id).orElse(null);
    }


}