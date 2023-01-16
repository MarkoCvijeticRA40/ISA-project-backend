package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.service.AppUserService;
import com.isa.blood_transfusion.service.RegisteredUserService;
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
@RequestMapping("/registeredusers")
public class RegisteredUserController {
    private final AppUserService appUserService;
    private final RegisteredUserService registeredUserService;
    private final RoleService roleService;

    @GetMapping("/{email}")
    public ResponseEntity<RegisteredUser> find(@PathVariable String email) {
        return new ResponseEntity<>(registeredUserService.find(email), HttpStatus.OK);
    }

    @PutMapping("/saveChanges")
    public ResponseEntity<RegisteredUser> saveChanges(@RequestBody RegisteredUser user) {
        return new ResponseEntity<>(registeredUserService.saveChanges(user), HttpStatus.OK);
    }


}
