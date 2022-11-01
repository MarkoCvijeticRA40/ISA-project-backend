package com.isa.blood_transfusion.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "blood_donors_info")
public class BloodDonorInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(name = "name_of_father")
    private String nameOfFather;
    @Column(name = "identity_number")
    private String identityNumber;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "phone_num")
    private String phoneNum;
    private String facility;
    private String profession;
    @Column(name = "number_of_blood_donations")
    private Integer numberOfBloodDonations;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    private Gender gender;

}
