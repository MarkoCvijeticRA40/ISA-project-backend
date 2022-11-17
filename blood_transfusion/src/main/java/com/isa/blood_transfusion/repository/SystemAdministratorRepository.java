package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.AppUserEntity;
import com.isa.blood_transfusion.entity.RegisteredUserEntity;
import com.isa.blood_transfusion.entity.SystemAdministratorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemAdministratorRepository extends JpaRepository<SystemAdministratorEntity, Long> {
    SystemAdministratorEntity findByEmail(String email);


}