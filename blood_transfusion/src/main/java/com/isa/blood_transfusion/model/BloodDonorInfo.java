package com.isa.blood_transfusion.model;

import com.isa.blood_transfusion.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodDonorInfo {
    private Long id;
    private String name;
    private String surname;
    private String nameOfFather;
    private String identityNumber;
    private LocalDate dateOfBirth;
    private String phoneNum;
    private String facility;
    private String profession;
    private Integer numberOfBloodDonations;
    private Address address;
    private Gender gender;
}
