package com.isa.blood_transfusion.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("MS")
@Entity
public class MedicalStaffEntity extends UserEntity {

}
