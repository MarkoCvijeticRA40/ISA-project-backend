package com.isa.blood_transfusion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FreeAppointment {
    private Long id;
    private LocalDateTime date;
    private Integer duration;
    private Center center;
    private MedicalStaff medicalStaff;
}
