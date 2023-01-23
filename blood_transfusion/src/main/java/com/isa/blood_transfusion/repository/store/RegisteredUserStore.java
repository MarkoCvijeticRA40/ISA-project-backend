package com.isa.blood_transfusion.repository.store;

import com.isa.blood_transfusion.model.RegisteredUser;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RegisteredUserStore {
    RegisteredUser save(RegisteredUser user);

    List<RegisteredUser> findAll();

    List<RegisteredUser> findAll(Pageable pageable);

    List<RegisteredUser> getByNameAndSurname(String name, String surname, Pageable pageable);

    RegisteredUser update(RegisteredUser registeredUser);

    RegisteredUser find(String email);

}
