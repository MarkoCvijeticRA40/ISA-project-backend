package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.RegisteredUserEntity;
import com.isa.blood_transfusion.entity.SystemAdministratorEntity;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.model.SystemAdministrator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class SystemAdministratorConverter {
    private RoleConverter roleConverter;
    private AddressConverter addressConverter;
    private UserCategoryConverter userCategoryConverter;
    private CenterConverter centerConverter;
    private ScheduledAppointmentConverter scheduledAppointmentConverter;
    private PerformedAppointmentConverter performedAppointmentConverter;

    public SystemAdministrator toModel(SystemAdministratorEntity systemAdministratorEntity) {
        return new SystemAdministrator(systemAdministratorEntity.getId(),
                systemAdministratorEntity.getEmail(),
                systemAdministratorEntity.getPassword(),
                systemAdministratorEntity.getName(),
                systemAdministratorEntity.getSurname(),
                systemAdministratorEntity.getPhoneNum(),
                systemAdministratorEntity.getIdentityNumber(),
                systemAdministratorEntity.getProfession(),
                systemAdministratorEntity.getFacilityInfo(),
                roleConverter.toModel(systemAdministratorEntity.getRole()),
                addressConverter.toModel(systemAdministratorEntity.getAddress()),
                systemAdministratorEntity.getGender()
        );
    }

    public Set<SystemAdministrator> toModel(Set<SystemAdministratorEntity> systemAdministratorEntities) {
        Set<SystemAdministrator>systemAdministrators = new HashSet<>();
        for (var r : systemAdministratorEntities) {
            systemAdministrators.add(new SystemAdministrator(r.getId(),
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

        return systemAdministrators;
    }

    public SystemAdministratorEntity toEntity(SystemAdministrator systemAdministrator) {
        return new SystemAdministratorEntity(systemAdministrator.getId(),
                systemAdministrator.getEmail(),
                systemAdministrator.getPassword(),
                systemAdministrator.getName(),
                systemAdministrator.getSurname(),
                systemAdministrator.getPhoneNum(),
                systemAdministrator.getIdentityNumber(),
                systemAdministrator.getProfession(),
                systemAdministrator.getFacilityInfo(),
                roleConverter.toEntity(systemAdministrator.getRole()),
                addressConverter.toEntity(systemAdministrator.getAddress()),
                systemAdministrator.getGender()
        );
    }

    public Set<SystemAdministratorEntity> toEntity(Set<SystemAdministrator> systemAdministrators) {
        Set<SystemAdministratorEntity> systemAdministratorEntities = new HashSet<>();
        for (var r : systemAdministrators) {
            systemAdministratorEntities.add(new SystemAdministratorEntity(r.getId(),
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
        return systemAdministratorEntities;
    }

}
