package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.AppUserEntity;
import com.isa.blood_transfusion.entity.RegisteredUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUserEntity, Long> {
    Page<RegisteredUserEntity> findAll(Pageable pageable);
    RegisteredUserEntity findByEmail(String email);

    @Query("select distinct u from users u where LOWER(u.name) like %:name% and LOWER(surname) like %:surname%")
    Page<RegisteredUserEntity> findByNameAndSurname(String name, String surname,Pageable pageable);
    //where LOWER(u.name) like %:name% and LOWER(surname) like %:surname%"
}
