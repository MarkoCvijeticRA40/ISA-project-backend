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
@Entity(name = "canceled_appointments")
public class CanceledAppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "center_id")
    private CenterEntity center;
    @Column(name = "date", nullable = false)
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "registered_user_id")
    private RegisteredUserEntity registeredUser;
}
