package com.isa.blood_transfusion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Long id;
    private String street;
    private String number;
    private String city;
    private String state;
    private Double longitude;
    private Double latitude;
}
