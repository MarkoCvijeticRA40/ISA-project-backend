package com.isa.blood_transfusion.entities;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phoneNum;
    private String identityNumber;
    private String profession;
    private String facilityInfo;
    @ManyToOne
    @JoinColumn(name="role_id")
    private RoleEntity role;
    @ManyToOne
    @JoinColumn(name="address_id")
    private AddressEntity address;
    private Gender gender;
}
