package com.isa.blood_transfusion.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("SA")
@Entity(name = "scheduled_appointments")
public class ScheduledAppointmentEntity extends FreeAppointmentEntity {

}
