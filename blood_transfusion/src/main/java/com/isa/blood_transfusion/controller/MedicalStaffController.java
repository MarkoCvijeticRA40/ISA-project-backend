package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.MedicalStaff;
import com.isa.blood_transfusion.service.MedicalStaffService;
import com.isa.blood_transfusion.service.RoleService;
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
@RequestMapping("/medicalstaff")
public class MedicalStaffController {
    private final MedicalStaffService medicalStaffService;
    private final RoleService roleService;

    @GetMapping("/{email}")
    public ResponseEntity<MedicalStaff> find(@PathVariable String email) {
        return new ResponseEntity<>(medicalStaffService.find(email), HttpStatus.OK);
    }

    @PutMapping("/saveChanges")
    public ResponseEntity<MedicalStaff> saveChanges(@RequestBody MedicalStaff medicalStaff) {
        return new ResponseEntity<>(medicalStaffService.saveStaff(medicalStaff), HttpStatus.OK);
    }


    @PostMapping("/registerStaff")
    public ResponseEntity<MedicalStaff> registerMedicalStaff(@RequestBody MedicalStaff medicalStaff) {
        return new ResponseEntity<>(medicalStaffService.saveStaff(medicalStaff), HttpStatus.OK);
    }


}
