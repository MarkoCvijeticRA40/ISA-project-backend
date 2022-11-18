package com.isa.blood_transfusion.entity;

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
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "name_of_father", nullable = false)
    private String nameOfFather;
    @Column(name = "identity_number", nullable = false)
    private String identityNumber;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "phone_num", nullable = false)
    private String phoneNum;
    @Column(name = "facility", nullable = false)
    private String facility;
    @Column(name = "profession", nullable = false)
    private String profession;
    @Column(name = "number_of_blood_donations", nullable = false)
    private Integer numberOfBloodDonations;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @Column(name = "has_already_donated_blood", nullable = false)
    private Boolean hasAlreadyDonatedBlood;
    @Column(name = "is_profession_dangerous", nullable = false)
    private Boolean isProfessionDangerous;
    @Column(name = "was_rejected_to_donate_blood", nullable = false)
    private Boolean wasRejectedToDonateBlood;
    @Column(name = "is_taking_any_medicines", nullable = false)
    private Boolean isTakingAnyMedicines;
    @Column(name = "has_some_allergies", nullable = false)
    private Boolean hasSomeAllergies;
    @Column(name = "has_chronic_disease", nullable = false)
    private Boolean hasChronicDisease;
    @Column(name = "is_feeling_healthy", nullable = false)
    private Boolean isFeelingHealthy;


}
