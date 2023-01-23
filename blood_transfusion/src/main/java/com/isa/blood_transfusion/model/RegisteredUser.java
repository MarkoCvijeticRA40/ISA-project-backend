package com.isa.blood_transfusion.model;

import com.isa.blood_transfusion.entity.BloodDonorInfoEntity;
import com.isa.blood_transfusion.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RegisteredUser extends AppUser {
    private Integer points;
    private Integer numOfPenalties;
    private UserCategory userCategory;
    private Set<Center> visitedCenters;
    private Set<ScheduledAppointment> scheduledAppointments;
    private Set<PerformedAppointment> performedAppointments;

    public RegisteredUser(Long id, String email, String password, String name, String surname, String phoneNum, String identityNumber, String profession, String facilityInfo, Role role, Address address, Gender gender, boolean enabled, Timestamp lastPasswordResetDate, Integer points, Integer numOfPenalties, UserCategory userCategory, Set<Center> visitedCenters, Set<ScheduledAppointment> scheduledAppointments, Set<PerformedAppointment> performedAppointments) {
        super(id, email, password, name, surname, phoneNum, identityNumber, profession, facilityInfo, role, address, gender, enabled, lastPasswordResetDate);
        this.points = points;
        this.numOfPenalties = numOfPenalties;
        this.userCategory = userCategory;
        this.visitedCenters = visitedCenters;
        this.scheduledAppointments = scheduledAppointments;
        this.performedAppointments = performedAppointments;
    }
}
