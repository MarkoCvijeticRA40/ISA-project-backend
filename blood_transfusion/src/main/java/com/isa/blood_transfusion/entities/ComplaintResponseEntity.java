package com.isa.blood_transfusion.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "complaint_responses")
public class ComplaintResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "complaint_id", referencedColumnName = "id")
    private ComplaintEntity complaint;
}
