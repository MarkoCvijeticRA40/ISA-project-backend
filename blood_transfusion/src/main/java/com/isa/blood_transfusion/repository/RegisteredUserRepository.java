package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.RegisteredUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUserEntity, Long> {
    RegisteredUserEntity findByEmail(String email);
}
