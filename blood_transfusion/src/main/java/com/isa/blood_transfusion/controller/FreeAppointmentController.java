package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.FreeAppointment;
import com.isa.blood_transfusion.service.FreeAppointmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/freeapp")
public class FreeAppointmentController {
    private final FreeAppointmentService service;

    @PostMapping("/create")
    public ResponseEntity<FreeAppointment> freeAppointment(@RequestBody FreeAppointment appointment) {
        return new ResponseEntity<>(service.save(appointment), HttpStatus.CREATED);
    }

    @GetMapping("/searchByDate/{dateString}")
    public ResponseEntity<List<FreeAppointment>> getByDate(@PathVariable String dateString, Pageable pageable) {
        LocalDateTime date = LocalDateTime.parse(dateString);
        return new ResponseEntity<>(service.getByDate(date, pageable), HttpStatus.OK);
    }

    @GetMapping("center/{centerId}")
    public ResponseEntity<List<FreeAppointment>> get(@PathVariable Long centerId) {
        return new ResponseEntity<>(service.get(centerId), HttpStatus.OK);
    }

    @GetMapping("center/{centerId}/{registeredUserId}")
    public ResponseEntity<List<FreeAppointment>> get(@PathVariable Long centerId, @PathVariable Long registeredUserId) {
        return new ResponseEntity<>(service.get(centerId, registeredUserId), HttpStatus.OK);
    }

    @GetMapping("getByDateAsc/{centerId}/{registeredUserId}")
    public ResponseEntity<List<FreeAppointment>> getByDateAsc(@PathVariable Long centerId, @PathVariable Long registeredUserId) {
        return new ResponseEntity<>(service.findByDateAsc(centerId, registeredUserId), HttpStatus.OK);
    }

    @GetMapping("getByDateDesc/{centerId}/{registeredUserId}")
    public ResponseEntity<List<FreeAppointment>> getByDateDesc(@PathVariable Long centerId, @PathVariable Long registeredUserId) {
        return new ResponseEntity<>(service.findByDateDesc(centerId, registeredUserId), HttpStatus.OK);
    }
}
