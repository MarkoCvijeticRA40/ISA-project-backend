package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.Address;
import com.isa.blood_transfusion.model.AppUser;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.model.Role;
import com.isa.blood_transfusion.service.AppUserService;
import com.isa.blood_transfusion.service.RegisteredUserService;
import com.isa.blood_transfusion.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
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

    @GetMapping("/search/{name}/{surname}")
    public ResponseEntity<List<RegisteredUser>> getByNameAndSurname(@PathVariable String name, @PathVariable String surname , Pageable pageable) {
        return new ResponseEntity<>(registeredUserService.getByNameAndSurname(name,surname , pageable), HttpStatus.OK);
    }


    @GetMapping("/searchSurname/{surname}")
    public ResponseEntity<List<RegisteredUser>> getBySurname( @PathVariable String surname , Pageable pageable) {
        return new ResponseEntity<>(registeredUserService.getBySurname(surname , pageable), HttpStatus.OK);
    }


    @GetMapping("/searchName/{name}")
    public ResponseEntity<List<RegisteredUser>> getByName(@PathVariable String name, Pageable pageable) {
        return new ResponseEntity<>(registeredUserService.getByName(name , pageable), HttpStatus.OK);
    }



    @PostMapping("/registerUser")
    public ResponseEntity<RegisteredUser> registerUser(@RequestBody RegisteredUser user) {
        return new ResponseEntity<>(registeredUserService.save(user), HttpStatus.CREATED);
    }



}
