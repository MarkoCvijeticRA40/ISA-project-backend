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
    private ScheduledAppointmentConverter scheduledAppointmentConverter;
    private PerformedAppointmentConverter performedAppointmentConverter;

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
                registeredUserEntity.getPoints(),
                registeredUserEntity.getNumOfPenalties(),
                userCategoryConverter.toModel(registeredUserEntity.getUserCategory()),
                centerConverter.toModel(registeredUserEntity.getVisitedCenters()),
                scheduledAppointmentConverter.toModel(registeredUserEntity.getScheduledAppointments()),
                performedAppointmentConverter.toModel(registeredUserEntity.getPerformedAppointments())
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
                    r.getPoints(),
                    r.getNumOfPenalties(),
                    userCategoryConverter.toModel(r.getUserCategory()),
                    centerConverter.toModel(r.getVisitedCenters()),
                    scheduledAppointmentConverter.toModel(r.getScheduledAppointments()),
                    performedAppointmentConverter.toModel(r.getPerformedAppointments())
            ));
        }

        return registeredUsers;
    }


}
