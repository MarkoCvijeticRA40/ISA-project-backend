package com.isa.blood_transfusion.repository;

import com.isa.blood_transfusion.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
