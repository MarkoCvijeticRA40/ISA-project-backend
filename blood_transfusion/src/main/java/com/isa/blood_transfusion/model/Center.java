package com.isa.blood_transfusion.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Center {
    private Long id;
    private String name;
    private String description;
    private Double avgGrade;
    private Address address;
    private WorkTime workTime;
    private Set<Blood> blood = new HashSet<Blood>();
    private Set<Equipment> equipments = new HashSet<Equipment>();
    private Set<FreeAppointment> freeAppointments = new HashSet<FreeAppointment>();
    private Set<MedicalStaff> medicalStaff = new HashSet<MedicalStaff>();
}
