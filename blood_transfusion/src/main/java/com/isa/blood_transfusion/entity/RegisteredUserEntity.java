package com.isa.blood_transfusion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("RU")
@Entity
public class RegisteredUserEntity extends AppUserEntity {
    @Column(name = "points", nullable = false)
    private Integer points;
    @Column(name = "num_of_penalties", nullable = false)
    private Integer numOfPenalties;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_category_id", referencedColumnName = "id")
    private UserCategoryEntity userCategory;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "registered_users_centers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "center_id"))
    private Set<CenterEntity> visitedCenters;
    @OneToMany(mappedBy = "registeredUser", fetch = FetchType.EAGER)
    private Set<ScheduledAppointmentEntity> scheduledAppointments;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "registered_user_id")
    private Set<PerformedAppointmentEntity> performedAppointments;

    public RegisteredUserEntity(Long id, String email, String password, String name, String surname, String phoneNum, String identityNumber, String profession, String facilityInfo, RoleEntity role, AddressEntity address, Gender gender, Integer points, Integer numOfPenalties, UserCategoryEntity userCategory, Set<CenterEntity> visitedCenters, Set<ScheduledAppointmentEntity> scheduledAppointments, Set<PerformedAppointmentEntity> performedAppointments) {
        super(id, email, password, name, surname, phoneNum, identityNumber, profession, facilityInfo, role, address, gender);
        this.points = points;
        this.numOfPenalties = numOfPenalties;
        this.userCategory = userCategory;
        this.visitedCenters = visitedCenters;
        this.scheduledAppointments = scheduledAppointments;
        this.performedAppointments = performedAppointments;
    }
}
