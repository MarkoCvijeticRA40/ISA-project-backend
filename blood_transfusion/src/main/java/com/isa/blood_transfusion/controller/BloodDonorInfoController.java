package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.BloodDonorInfo;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.service.BloodDonorInfoService;
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
@RequestMapping("/info")
public class BloodDonorInfoController {
    private final BloodDonorInfoService service;

    @PostMapping
    public ResponseEntity<BloodDonorInfo> save(@RequestBody BloodDonorInfo bloodDonorInfo) {
        return new ResponseEntity<>(service.save(bloodDonorInfo), HttpStatus.CREATED);
    }
}
