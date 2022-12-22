package com.isa.blood_transfusion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "work_times")
public class WorkTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_time", nullable = true)
    private LocalTime startTime;
    @Column(name = "end_time", nullable = true)
    private LocalTime endTime;
}
