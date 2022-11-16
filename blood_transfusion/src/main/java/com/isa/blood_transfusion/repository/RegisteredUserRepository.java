package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.AppUserEntity;
import com.isa.blood_transfusion.entity.RegisteredUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUserEntity, Long> {
    Page<RegisteredUserEntity> findAll(Pageable pageable);
    RegisteredUserEntity findByEmail(String email);


}
