package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.AppUser;
import com.isa.blood_transfusion.model.Center;
import com.isa.blood_transfusion.model.ScheduledAppointment;
import com.isa.blood_transfusion.service.BloodDonorInfoService;
import com.isa.blood_transfusion.service.PerformedAppointmentService;
import com.isa.blood_transfusion.service.ScheduledAppointmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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
@RequestMapping("/scheduledapp")
public class ScheduledAppointmentController {

    private final ScheduledAppointmentService service;
    private final BloodDonorInfoService bloodDonorInfoService;
    private final PerformedAppointmentService performedAppointmentService;

    @PostMapping("/create")
    public ResponseEntity<ScheduledAppointment> scheduledAppointment(@RequestBody ScheduledAppointment appointment) {
        return new ResponseEntity<>(service.save(appointment), HttpStatus.CREATED);
    }

    @PostMapping("/create/{freeAppointmentId}/{registeredUserId}")
    public ResponseEntity<ScheduledAppointment> schedule(@PathVariable Long freeAppointmentId, @PathVariable Long registeredUserId) {
        if (bloodDonorInfoService.isDonorInfoFilled(registeredUserId) && !performedAppointmentService.hasDonatedBloodInLastSixMonths(registeredUserId))
            return new ResponseEntity<>(service.create(freeAppointmentId, registeredUserId), HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduledAppointment>> findAll() {

        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @PostMapping("/create/{dateString}/{registeredUserId}/{centerId}")
    public ResponseEntity<ScheduledAppointment> specificSchedule(@PathVariable String dateString,@PathVariable Long registeredUserId,@PathVariable Long centerId) {
        if (bloodDonorInfoService.isDonorInfoFilled(registeredUserId) && !performedAppointmentService.hasDonatedBloodInLastSixMonths(registeredUserId))
            return new ResponseEntity<>(service.specificSchedule(dateString, registeredUserId,centerId), HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }


    @GetMapping("/center/{id}")
    public ResponseEntity<List<ScheduledAppointment>> findByCenterId(@PathVariable Long id) {
        return new ResponseEntity<>(service.findByCenterId(id),HttpStatus.OK);
    }
    
    @GetMapping("{registeredUserId}")
    public ResponseEntity<List<ScheduledAppointment>> getByRegisteredUserId(@PathVariable Long registeredUserId) {
        return new ResponseEntity<>(service.get(registeredUserId), HttpStatus.OK);
    }

    @PostMapping("/cancelAppointment/{scheduledAppointmentId}/{registeredUserId}")
    public ResponseEntity<ScheduledAppointment> cancelAppointment(@PathVariable Long scheduledAppointmentId, @PathVariable Long registeredUserId) {
        if(!service.isAppointmentInNext24Hours(scheduledAppointmentId))
            return new ResponseEntity<>(service.cancelAppointment(scheduledAppointmentId, registeredUserId), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
    }


}
