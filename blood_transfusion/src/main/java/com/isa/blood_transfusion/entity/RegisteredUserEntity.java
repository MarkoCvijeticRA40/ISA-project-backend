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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_category_id", referencedColumnName = "id")
    private UserCategoryEntity userCategory;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "registered_users_centers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "center_id"))
    private Set<CenterEntity> visitedCenters;
    @OneToMany(mappedBy = "registeredUser", fetch = FetchType.LAZY)
    private Set<ScheduledAppointmentEntity> scheduledAppointments;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "registered_user_id")
    private Set<PerformedAppointmentEntity> performedAppointments;
}
