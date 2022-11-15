package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.UserCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCategoryRepository extends JpaRepository<UserCategoryEntity, Long> {
    public UserCategoryEntity findByName(String name);
}
