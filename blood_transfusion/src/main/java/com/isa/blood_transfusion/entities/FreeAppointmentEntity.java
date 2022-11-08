package com.isa.blood_transfusion.entities;

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
@DiscriminatorColumn(name = "appointment_type")
@Entity(name = "free_appointments")
public class FreeAppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private Integer duration;
    @ManyToOne
    @JoinColumn(name = "center_id")
    private CenterEntity center;
    @ManyToOne
    @JoinColumn(name = "medical_staff_id")
    private MedicalStaffEntity medicalStaff;
}
