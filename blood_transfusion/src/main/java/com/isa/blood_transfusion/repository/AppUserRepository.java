package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUserEntity, Long> {
    AppUserEntity findByEmail(String email);
}
