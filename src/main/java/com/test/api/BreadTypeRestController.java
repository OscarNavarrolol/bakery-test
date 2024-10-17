package com.test.api;

import com.test.entity.BreadType;
import com.test.entity.Flour;
import com.test.service.BreadTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bread")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BreadTypeRestController {

    @Autowired
    private BreadTypeService breadTypeService;

    @GetMapping("/")
    public ResponseEntity<List<BreadType>> getBreadTypes() {
        List<BreadType> breadTypes = breadTypeService.getAll();

        if (breadTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(breadTypes);
    }

    @PostMapping("/")
    public ResponseEntity<BreadType> createBreadType(@RequestBody BreadType breadType) {
        BreadType breadTypeCreated = breadTypeService.saveBreadType(breadType);
        return new ResponseEntity<>(breadTypeCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{bread_id}")
    public ResponseEntity<BreadType> getBreadTypeById(@PathVariable("bread_id") Long breadId) {
        BreadType breadTypes = breadTypeService.getById(breadId);
        if( breadTypes != null){
            return new ResponseEntity<>(breadTypes, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{bread_id}")
    public ResponseEntity<BreadType> updateBreadType(@PathVariable("bread_id") Long breadId, @RequestBody BreadType breadType) {
        BreadType breadTypes = breadTypeService.updateBreadType(breadId, breadType);
        if (breadTypes != null) {
            return new ResponseEntity<>(breadTypes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
// TODo
    @DeleteMapping("/{bread_id}")
    public ResponseEntity<BreadType> deleteBreadType(@PathVariable("bread_id") Long breadId) {
        BreadType breadTypes = breadTypeService.getById(breadId);
        if (breadTypes != null) {
            breadTypeService.deleteBreadType(breadId);
            return new ResponseEntity<>(breadTypes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
