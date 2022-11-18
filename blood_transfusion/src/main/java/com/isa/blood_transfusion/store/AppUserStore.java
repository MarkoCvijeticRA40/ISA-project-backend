package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.AppUser;

import java.util.List;

public interface AppUserStore {
    AppUser save(AppUser appUser);

    AppUser find(String email);

    List<AppUser> findAll();
}
