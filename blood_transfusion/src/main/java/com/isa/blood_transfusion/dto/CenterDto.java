package com.isa.blood_transfusion.dto;

import com.isa.blood_transfusion.model.Blood;
import com.isa.blood_transfusion.model.Equipment;
import com.isa.blood_transfusion.model.FreeAppointment;
import com.isa.blood_transfusion.model.MedicalStaff;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CenterDto {
    private Long id;
    private String name;
    private String description;
    private Double avgGrade;
    private AddressDto address;
    private WorkTimeDto workTime;
    private Set<Blood> blood = new HashSet<Blood>();
    private Set<Equipment> equipments = new HashSet<Equipment>();
    private Set<FreeAppointment> freeAppointments = new HashSet<FreeAppointment>();
    private Set<MedicalStaff> medicalStaff = new HashSet<MedicalStaff>();
}
