package com.isa.blood_transfusion.controller;
import com.isa.blood_transfusion.service.FreeAppointmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/freeappointment")
public class FreeAppointmentController {

    private final FreeAppointmentService service;


}
