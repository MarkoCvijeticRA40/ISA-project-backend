package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.repository.RegisteredUserRepository;
import com.isa.blood_transfusion.store.RegisteredUserStore;
import com.isa.blood_transfusion.store.RoleStore;
import com.isa.blood_transfusion.store.UserCategoryStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
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
    private final RegisteredUserRepository registeredUserRepository;

    @Override
    public RegisteredUser save(RegisteredUser user) {

        if (user.getId() == 0) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }else{

        if (isPasswordChanged(user.getEmail(), user.getPassword()) == true) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        }
        user.setRole(roleStore.find("REGISTERED_USER"));
        user.setUserCategory(userCategoryStore.find("Regular"));
        user.setNumOfPenalties(0);
        user.setLastPasswordResetDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        return store.save(user);
    }

    @Override
    public RegisteredUser saveChanges(RegisteredUser user) {
        return store.save(user);
    }

    @Override
    public boolean isPasswordChanged(String email,String password) {

        RegisteredUser registeredUser = store.find(email);

        if (registeredUser.getPassword().equals(password)){
            return false;
        }
        return true;
    }

    @Override
    public List<RegisteredUser> findAll() {
        return store.findAll();
    }

    @Override
    public List<RegisteredUser> findAll(Pageable pageable) {
        return store.findAll(pageable);
    }

    /*
    @Override
    public RegisteredUser find(String email) {
        return store.find(email);
    }*/
    public List<RegisteredUser> getByNameAndSurname(String name, String surname, Pageable pageable) {
        return store.getByNameAndSurname(name.toLowerCase(), surname.toLowerCase(), pageable);
    }

    @Override
    public List<RegisteredUser> getByName(String name, Pageable pageable) {
        String surname = "";
        return store.getByNameAndSurname(name.toLowerCase(), surname.toLowerCase(), pageable);
    }

    @Override
    public List<RegisteredUser> getBySurname(String surname, Pageable pageable) {
        String name = "";
        return store.getByNameAndSurname(name.toLowerCase(), surname.toLowerCase(), pageable);
    }

    @Override
    public RegisteredUser activate(String email) {
        RegisteredUser user = store.find(email);
        user.setEnabled(true);
        return store.update(user);
    }


    public RegisteredUser find(String email) {
        return store.find(email);
    }
}
