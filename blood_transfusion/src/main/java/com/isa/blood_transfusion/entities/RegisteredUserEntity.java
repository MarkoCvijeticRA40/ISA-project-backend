package com.isa.blood_transfusion.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("RU")
@Entity
public class RegisteredUserEntity extends UserEntity {
    private Integer points;
    @Column(name = "num_of_penalties")
    private Integer numOfPenalties;
}
