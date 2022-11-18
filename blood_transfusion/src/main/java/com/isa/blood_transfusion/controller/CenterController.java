package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.dto.CenterDto;
import com.isa.blood_transfusion.dto.SearchInput;
import com.isa.blood_transfusion.model.Center;
import com.isa.blood_transfusion.service.CenterService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/centers")
public class CenterController {

    private final CenterService centerService;

    @GetMapping
    public ResponseEntity<List<Center>> findAll() {
        return new ResponseEntity<>(centerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Center> getById(@PathVariable Long id) {
        return new ResponseEntity<>(centerService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Center>> search(@RequestParam(name = "searchByName") String searchByName, @RequestParam(name = "searchByPlace") String searchByPlace){
        return new ResponseEntity<>(centerService.search(searchByName, searchByPlace), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Center>> filter(@RequestParam(name = "searchByName") String searchByName, @RequestParam(name = "searchByPlace") String searchByPlace,
                                               @RequestParam(name = "gradeFrom") Double filterByGradeFrom, @RequestParam(name = "gradeTo") Double filterByGradeTo){
        return new ResponseEntity<>(centerService.filter(searchByName, searchByPlace, filterByGradeFrom, filterByGradeTo), HttpStatus.OK);
    }

    @GetMapping("/medical-staff/{id}")
    public ResponseEntity<Center> getCenterByMedicalStaffId(@PathVariable Long id) {
        System.out.println(centerService.getCenterByMedicalStaffId(id));
        return new ResponseEntity<>(centerService.getCenterByMedicalStaffId(id), HttpStatus.OK);
    }

    @PutMapping("/update-center/{id}")
    public ResponseEntity<Center> updateCenter(@RequestBody CenterDto centerDto, @PathVariable Long id) {
        System.out.println(LocalTime.parse(centerDto.getWorkTime().getStartTime()));
        return new ResponseEntity<>(centerService.updateCenter(centerDto, id), HttpStatus.OK);
    }
}
