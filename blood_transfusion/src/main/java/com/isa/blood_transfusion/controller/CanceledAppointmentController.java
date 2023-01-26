package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.CanceledAppointment;
import com.isa.blood_transfusion.service.CanceledAppointmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/canceledAppointments")
public class CanceledAppointmentController {
    private final CanceledAppointmentService service;

    @PostMapping
    ResponseEntity<CanceledAppointment> save(@RequestBody CanceledAppointment canceledAppointment) {
        return new ResponseEntity<>(service.save(canceledAppointment), HttpStatus.CREATED);
    }
}
