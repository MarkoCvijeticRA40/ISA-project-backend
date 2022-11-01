package com.isa.blood_transfusion.entities;

import javax.persistence.*;
import java.util.List;

@DiscriminatorValue("RU")
@Entity
public class RegisteredUserEntity extends UserEntity {
    private Integer points;
    @Column(name = "num_of_penalties")
    private Integer numOfPenalties;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_category_id", referencedColumnName = "id")
    private UserCategoryEntity userCategory;
    @ManyToMany
    @JoinTable(
            name = "registered_users_centers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "center_id"))
    private List<CenterEntity> visitedCenters;
    @OneToMany(mappedBy = "registeredUser")
    private List<ScheduledAppointmentEntity> scheduledAppointments;
    @OneToMany
    @JoinColumn(name = "registered_user_id")
    private List<PerformedAppointmentEntity> performedAppointments;
}
