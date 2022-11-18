package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.Center;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.service.CenterService;
import com.isa.blood_transfusion.service.MedicalStaffService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/centers")
public class CenterController {

    private final CenterService centerService;
    private final MedicalStaffService msService;

    @GetMapping
    public ResponseEntity<List<Center>> findAll() {
        return new ResponseEntity<>(centerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Center> getById(@PathVariable Long id) {
        return new ResponseEntity<>(centerService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/registerCenter")
    public ResponseEntity<Center> registerCenter(@RequestBody Center center) {
       // msService.saveStaff(center.getMedicalStaff().iterator().next());
        return new ResponseEntity<>(centerService.save(center), HttpStatus.CREATED);
    }



}
