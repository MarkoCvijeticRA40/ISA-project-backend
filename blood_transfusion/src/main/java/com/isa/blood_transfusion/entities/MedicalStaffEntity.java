package com.isa.blood_transfusion.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "medical_staff")
public class MedicalStaffEntity extends UserEntity {

}
