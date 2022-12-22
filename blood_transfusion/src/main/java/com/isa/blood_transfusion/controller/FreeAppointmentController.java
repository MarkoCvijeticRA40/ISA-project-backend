package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.FreeAppointment;
import com.isa.blood_transfusion.service.FreeAppointmentService;
import com.isa.blood_transfusion.store.RoleStore;
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
@RequestMapping("/freeapp")
public class FreeAppointmentController {
    private final FreeAppointmentService service;
    private final RoleStore roleStore;

    @PostMapping("/create")
    public ResponseEntity<FreeAppointment> freeAppointment(@RequestBody FreeAppointment appointment) {
        return new ResponseEntity<>(service.save(appointment), HttpStatus.CREATED);
    }
}
