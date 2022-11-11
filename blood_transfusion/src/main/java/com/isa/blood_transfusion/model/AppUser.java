package com.isa.blood_transfusion.model;

import com.isa.blood_transfusion.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phoneNum;
    private String identityNumber;
    private String profession;
    private String facilityInfo;
    private Role role;
    private Address address;
    private Gender gender;
}
