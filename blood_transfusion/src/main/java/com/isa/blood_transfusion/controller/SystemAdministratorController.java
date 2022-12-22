package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.AppUser;
import com.isa.blood_transfusion.model.MedicalStaff;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.model.SystemAdministrator;
import com.isa.blood_transfusion.service.AppUserService;
import com.isa.blood_transfusion.service.RegisteredUserService;
import com.isa.blood_transfusion.service.RoleService;
import com.isa.blood_transfusion.service.SystemAdministratorService;
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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/administrators")
public class SystemAdministratorController {
    private final SystemAdministratorService systemAdministratorService;
    private final RegisteredUserService registeredUserService;
    private final RoleService roleService;

    @GetMapping("/{email}")
    public ResponseEntity<SystemAdministrator> find(@PathVariable String email) {
        return new ResponseEntity<>(systemAdministratorService.find(email), HttpStatus.OK);
    }

    @PutMapping("/saveChanges")
    public ResponseEntity<SystemAdministrator> saveChanges(@RequestBody SystemAdministrator systemAdministrator) {
        return new ResponseEntity<>(systemAdministratorService.save(systemAdministrator), HttpStatus.OK);
    }


    @PostMapping("/registerSystemAdministrator")
    public ResponseEntity<SystemAdministrator> registerSystemAdministrator(@RequestBody SystemAdministrator systemAdministrator) {
        return new ResponseEntity<>(systemAdministratorService.save(systemAdministrator), HttpStatus.OK);
    }

}
