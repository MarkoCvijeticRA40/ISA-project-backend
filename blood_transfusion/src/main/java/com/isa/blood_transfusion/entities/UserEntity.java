package com.isa.blood_transfusion.entities;

import javax.persistence.*;

@Inheritance
@DiscriminatorColumn(name = "user_type")
@Entity(name = "users")
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    @Column(name = "phone_num")
    private String phoneNum;
    @Column(name = "identity_number")
    private String identityNumber;
    private String profession;
    @Column(name = "facility_info")
    private String facilityInfo;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    private Gender gender;
}
