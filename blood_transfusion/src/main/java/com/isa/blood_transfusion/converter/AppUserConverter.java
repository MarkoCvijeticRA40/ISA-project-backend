package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.AppUserEntity;
import com.isa.blood_transfusion.model.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class AppUserConverter {
    private RoleConverter roleConverter;
    private AddressConverter addressConverter;

    public AppUser toModel(AppUserEntity appUserEntity) {
        return new AppUser(appUserEntity.getId(),
                appUserEntity.getEmail(),
                appUserEntity.getPassword(),
                appUserEntity.getName(),
                appUserEntity.getSurname(),
                appUserEntity.getPhoneNum(),
                appUserEntity.getIdentityNumber(),
                appUserEntity.getProfession(),
                appUserEntity.getFacilityInfo(),
                roleConverter.toModel(appUserEntity.getRole()),
                addressConverter.toModel(appUserEntity.getAddress()),
                appUserEntity.getGender()
        );
    }

    public Set<AppUser> toModel(Set<AppUserEntity> appUserEntities) {
        Set<AppUser> appUsers = new HashSet<>();
        for (var r : appUserEntities) {
            appUsers.add(new AppUser(r.getId(),
                    r.getEmail(),
                    r.getPassword(),
                    r.getName(),
                    r.getSurname(),
                    r.getPhoneNum(),
                    r.getIdentityNumber(),
                    r.getProfession(),
                    r.getFacilityInfo(),
                    roleConverter.toModel(r.getRole()),
                    addressConverter.toModel(r.getAddress()),
                    r.getGender()
            ));
        }

        return appUsers;
    }

    public AppUserEntity toEntity(AppUser appUser) {
        return new AppUserEntity(appUser.getId(),
                appUser.getEmail(),
                appUser.getPassword(),
                appUser.getName(),
                appUser.getSurname(),
                appUser.getPhoneNum(),
                appUser.getIdentityNumber(),
                appUser.getProfession(),
                appUser.getFacilityInfo(),
                roleConverter.toEntity(appUser.getRole()),
                addressConverter.toEntity(appUser.getAddress()),
                appUser.getGender()
        );
    }

    public Set<AppUserEntity> toEntity(Set<AppUser> appUsers) {
        Set<AppUserEntity> appUserEntities = new HashSet<>();
        for (var r : appUsers) {
            appUserEntities.add(new AppUserEntity(r.getId(),
                    r.getEmail(),
                    r.getPassword(),
                    r.getName(),
                    r.getSurname(),
                    r.getPhoneNum(),
                    r.getIdentityNumber(),
                    r.getProfession(),
                    r.getFacilityInfo(),
                    roleConverter.toEntity(r.getRole()),
                    addressConverter.toEntity(r.getAddress()),
                    r.getGender()
            ));
        }

        return appUserEntities;
    }
}
