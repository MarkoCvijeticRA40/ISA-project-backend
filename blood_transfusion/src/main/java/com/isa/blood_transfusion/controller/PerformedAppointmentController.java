package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.service.PerformedAppointmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/performedAppointment")
public class PerformedAppointmentController {
    private final PerformedAppointmentService service;

    @GetMapping("/hasDonatedBloodInLastSixMonths/{registeredUserId}")
    public Boolean hasDonatedBloodInLastSixMonths(@PathVariable Long registeredUserId) {
        return service.hasDonatedBloodInLastSixMonths(registeredUserId);
    }
}
