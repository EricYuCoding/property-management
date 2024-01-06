package com.mycompany.propertymanagement.controller;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }

    @GetMapping("/properties/users/{userId}")
    public ResponseEntity<List<PropertyDTO>> getAllPropertiesForUser(@PathVariable("userId") Long userId){
        List<PropertyDTO> propertyList = propertyService.getAllPropertiesForUser(userId);
        return new ResponseEntity<>(propertyList, HttpStatus.OK);
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);

        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updatePropertyDescription(propertyDTO, propertyId);

        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updatePropertyPrice(propertyDTO, propertyId);

        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}











