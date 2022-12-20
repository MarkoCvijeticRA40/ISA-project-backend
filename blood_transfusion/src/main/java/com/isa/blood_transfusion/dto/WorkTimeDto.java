package com.isa.blood_transfusion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkTimeDto {
    private Long id;
    private String startTime;
    private String endTime;
}
