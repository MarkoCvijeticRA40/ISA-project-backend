package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser save(AppUser appUser);
    AppUser find(String email);
    List<AppUser> findAll();
    void addRoleToUser(String email, String roleName);

}
