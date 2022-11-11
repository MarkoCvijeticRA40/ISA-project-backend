package com.isa.blood_transfusion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Set<Blood> blood;
    private Set<Equipment> equipments;
    private Set<FreeAppointment> freeAppointments;
    private Set<MedicalStaff> medicalStaff;
}
