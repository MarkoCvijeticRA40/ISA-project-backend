package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.AppUser;
import com.isa.blood_transfusion.model.RegisteredUser;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RegisteredUserService {
    RegisteredUser save(RegisteredUser user);
    List<RegisteredUser> findAll();
    List<RegisteredUser> findAll(Pageable pageable);
    RegisteredUser find(String email);
    RegisteredUser saveChanges(RegisteredUser user);
    List<RegisteredUser> getByNameAndSurname(String name, String surname, Pageable pageable);
    List<RegisteredUser> getByName(String name,  Pageable pageable);
    List<RegisteredUser> getBySurname( String surname, Pageable pageable);
}
