package com.isa.blood_transfusion.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
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

    public FreeAppointmentEntity(Long id, LocalDateTime date, Integer duration, CenterEntity center, MedicalStaffEntity medicalStaff) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.center = center;
        this.medicalStaff = medicalStaff;
    }
}
