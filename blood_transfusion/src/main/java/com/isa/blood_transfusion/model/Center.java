package com.isa.blood_transfusion.model;

import com.isa.blood_transfusion.dto.AddressDto;
import com.isa.blood_transfusion.dto.CenterDto;
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
    private Set<MedicalStaff> medicalStaff = new HashSet<MedicalStaff>();
}
