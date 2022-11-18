package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.AppUser;
import com.isa.blood_transfusion.model.Role;
import com.isa.blood_transfusion.store.AppUserStore;
import com.isa.blood_transfusion.store.RoleStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserStore store;
    private final RoleStore roleStore;

    @Override
    public AppUser save(AppUser appUser) {
        return store.save(appUser);
    }

    @Override
    public AppUser find(String email) {
        return store.find(email);
    }

    @Override
    public List<AppUser> findAll() {
        return store.findAll();
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        AppUser appUser = store.find(email);
        Role role = roleStore.find(roleName);
        appUser.setRole(role);
        store.save(appUser);
    }
}
