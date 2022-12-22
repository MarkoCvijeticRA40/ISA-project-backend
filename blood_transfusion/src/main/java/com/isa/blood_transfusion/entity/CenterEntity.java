package com.isa.blood_transfusion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "centers")
public class CenterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "average_grade", nullable = false)
    private Double avgGrade;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_time_id", referencedColumnName = "id")
    private WorkTimeEntity workTime;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "center_id")
    private Set<BloodEntity> blood = new HashSet<BloodEntity>();
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "center_id")
    private Set<EquipmentEntity> equipments = new HashSet<EquipmentEntity>();
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "center_id")
    private Set<MedicalStaffEntity> medicalStaff = new HashSet<MedicalStaffEntity>();

}
