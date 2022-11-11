package com.isa.blood_transfusion.model;

import com.isa.blood_transfusion.entity.BloodType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blood {
    private Long id;
    private Double quantityInLiters;
    private BloodType bloodType;
}
