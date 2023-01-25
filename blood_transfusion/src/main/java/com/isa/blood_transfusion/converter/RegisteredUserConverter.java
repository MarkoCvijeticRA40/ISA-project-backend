package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.RegisteredUserEntity;
import com.isa.blood_transfusion.model.RegisteredUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class RegisteredUserConverter {
    private RoleConverter roleConverter;
    private AddressConverter addressConverter;
    private UserCategoryConverter userCategoryConverter;
    private CenterConverter centerConverter;

    public RegisteredUser toModel(RegisteredUserEntity registeredUserEntity) {
        return new RegisteredUser(registeredUserEntity.getId(),
                registeredUserEntity.getEmail(),
                registeredUserEntity.getPassword(),
                registeredUserEntity.getName(),
                registeredUserEntity.getSurname(),
                registeredUserEntity.getPhoneNum(),
                registeredUserEntity.getIdentityNumber(),
                registeredUserEntity.getProfession(),
                registeredUserEntity.getFacilityInfo(),
                roleConverter.toModel(registeredUserEntity.getRole()),
                addressConverter.toModel(registeredUserEntity.getAddress()),
                registeredUserEntity.getGender(),
                registeredUserEntity.isEnabled(),
                registeredUserEntity.getLastPasswordResetDate(),
                registeredUserEntity.getPoints(),
                registeredUserEntity.getNumOfPenalties(),
                userCategoryConverter.toModel(registeredUserEntity.getUserCategory()),
                centerConverter.toModel(registeredUserEntity.getVisitedCenters())
        );
    }

    public Set<RegisteredUser> toModel(Set<RegisteredUserEntity> registeredUserEntities) {
        Set<RegisteredUser> registeredUsers = new HashSet<>();
        for (var r : registeredUserEntities) {
            registeredUsers.add(new RegisteredUser(r.getId(),
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
                    r.getGender(),
                    r.isEnabled(),
                    r.getLastPasswordResetDate(),
                    r.getPoints(),
                    r.getNumOfPenalties(),
                    userCategoryConverter.toModel(r.getUserCategory()),
                    centerConverter.toModel(r.getVisitedCenters())
            ));
        }

        return registeredUsers;
    }

    public RegisteredUserEntity toEntity(RegisteredUser registeredUser) {
        return new RegisteredUserEntity(registeredUser.getId(),
                registeredUser.getEmail(),
                registeredUser.getPassword(),
                registeredUser.getName(),
                registeredUser.getSurname(),
                registeredUser.getPhoneNum(),
                registeredUser.getIdentityNumber(),
                registeredUser.getProfession(),
                registeredUser.getFacilityInfo(),
                roleConverter.toEntity(registeredUser.getRole()),
                addressConverter.toEntity(registeredUser.getAddress()),
                registeredUser.getGender(),
                registeredUser.isEnabled(),
                registeredUser.getLastPasswordResetDate(),
                registeredUser.getPoints(),
                registeredUser.getNumOfPenalties(),
                userCategoryConverter.toEntity(registeredUser.getUserCategory()),
                centerConverter.toEntity(registeredUser.getVisitedCenters())
        );
    }

    public Set<RegisteredUserEntity> toEntity(Set<RegisteredUser> registeredUsers) {
        Set<RegisteredUserEntity> registeredUserEntities = new HashSet<>();
        for (var r : registeredUsers) {
            registeredUserEntities.add(new RegisteredUserEntity(r.getId(),
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
                    r.getGender(),
                    r.isEnabled(),
                    r.getLastPasswordResetDate(),
                    r.getPoints(),
                    r.getNumOfPenalties(),
                    userCategoryConverter.toEntity(r.getUserCategory()),
                    centerConverter.toEntity(r.getVisitedCenters())
            ));
        }

        return registeredUserEntities;
    }

}
