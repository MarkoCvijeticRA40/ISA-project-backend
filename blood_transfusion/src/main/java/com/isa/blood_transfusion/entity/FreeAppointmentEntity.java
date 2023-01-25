package com.isa.blood_transfusion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "free_appointments")
public class FreeAppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date", nullable = false)
    private LocalDateTime date;
    @Column(name = "duration", nullable = false)
    private Integer duration;
    @ManyToOne
    @JoinColumn(name = "center_id")
    private CenterEntity center;
    @ManyToOne
    @JoinColumn(name = "medical_staff_id")
    private MedicalStaffEntity medicalStaff;
}
