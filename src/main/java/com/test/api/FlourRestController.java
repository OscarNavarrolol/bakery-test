package com.test.api;

import com.test.entity.Flour;
import com.test.repository.FlourRepository;
import com.test.service.FlourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flour")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class FlourRestController {

    @Autowired
    private FlourService flourService;

    @GetMapping("/")
    public ResponseEntity<List<Flour>> getFlour() {
        List<Flour> flours = flourService.getAll();

        if (flours.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(flours);
    }

    @PostMapping("/")
    public ResponseEntity<Flour> createFlour(@RequestBody Flour flour) {
        Flour flourCreated = flourService.saveFlour(flour);
        return new ResponseEntity<>(flourCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{flour_id}")
    public ResponseEntity<Flour> getFlourById(@PathVariable("flour_id") Long flourId) {
        Flour flour = flourService.getById(flourId);
        if( flour != null){
            return new ResponseEntity<>(flour, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{flour_id}")
    public ResponseEntity<Flour> updateFlour(@PathVariable("flour_id") Long flourId, @RequestBody Flour flour) {
        Flour flourUpdate = flourService.updateFlour(flourId, flour);
        if (flourUpdate != null) {
            return new ResponseEntity<>(flourUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{flour_id}")
    public ResponseEntity<Flour> deleteFlour(@PathVariable("flour_id") Long flourId) {
        Flour flour = flourService.getById(flourId);
        if (flour != null) {
            flourService.deleteFlour(flourId);
            return new ResponseEntity<>(flour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
