package com.isa.blood_transfusion.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "centers")
public class CenterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "average_grade")
    private Double avgGrade;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_time_id", referencedColumnName = "id")
    private WorkTimeEntity workTime;
    @OneToMany
    @JoinColumn(name = "center_id")
    private List<BloodEntity> blood;
    @OneToMany
    @JoinColumn(name = "center_id")
    private List<EquipmentEntity> equipments;
    @OneToMany(mappedBy = "center")
    private List<FreeAppointmentEntity> freeAppointments;
    @OneToMany
    @JoinColumn(name = "center_id")
    private List<MedicalStaffEntity> medicalStaff;

}
