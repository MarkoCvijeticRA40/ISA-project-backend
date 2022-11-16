package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.AppUser;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.store.RegisteredUserStore;
import com.isa.blood_transfusion.store.RoleStore;
import com.isa.blood_transfusion.store.UserCategoryStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class RegisteredUserServiceImpl implements RegisteredUserService {
    private final RegisteredUserStore store;
    private final RoleStore roleStore;
    private final UserCategoryStore userCategoryStore;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisteredUser save(RegisteredUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleStore.find("REGISTERED_USER"));
        user.setUserCategory(userCategoryStore.find("Regular"));
        user.setNumOfPenalties(0);
        return store.save(user);
    }

    @Override
    public RegisteredUser saveChanges(RegisteredUser user) {
        return store.save(user);
    }

    @Override
    public List<RegisteredUser> findAll() {
        return store.findAll();
    }

    @Override
    public List<RegisteredUser> findAll(Pageable pageable) {
        return store.findAll(pageable);
    }

    @Override
    public RegisteredUser find(String email) {
        return store.find(email);
    }
}
