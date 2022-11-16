package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.AppUser;
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

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class AppUserController {
    private final AppUserService appUserService;
    private final RegisteredUserService registeredUserService;
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<AppUser>> findAll() {
        return new ResponseEntity<>(appUserService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/registeredUsers")
    public ResponseEntity<List<RegisteredUser>> findAllRegisteredUsers() {
        return new ResponseEntity<>(registeredUserService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/registerUser")
    public ResponseEntity<RegisteredUser> registerUser(@RequestBody RegisteredUser user) {
        return new ResponseEntity<>(registeredUserService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<RegisteredUser> find(@PathVariable String email) {
        return new ResponseEntity<>(registeredUserService.find(email), HttpStatus.OK);
    }


}
