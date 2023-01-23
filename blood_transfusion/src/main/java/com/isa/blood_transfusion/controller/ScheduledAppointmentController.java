package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.ScheduledAppointment;
import com.isa.blood_transfusion.service.ScheduledAppointmentService;
import com.isa.blood_transfusion.repository.store.ScheduledAppointmentStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/scheduledapp")
public class ScheduledAppointmentController {

    private final ScheduledAppointmentService service;
    private final ScheduledAppointmentStore roleStore;

    @PostMapping("/create")
    public ResponseEntity<ScheduledAppointment> scheduledAppointment(@RequestBody ScheduledAppointment appointment) {
        return new ResponseEntity<>(service.save(appointment), HttpStatus.CREATED);
    }

}
