package org.nyu.onlinefoodorderingsystem.controller;

import org.nyu.onlinefoodorderingsystem.model.DeliveryPerson;
import org.nyu.onlinefoodorderingsystem.service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/deliveryperson")
public class DeliveryPersonController {

    @Autowired
    private DeliveryPersonService deliveryPersonService;

    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<String> addDeliveryPerson(@RequestBody DeliveryPerson deliveryPerson) {
        try {
            deliveryPersonService.addDeliveryPerson(deliveryPerson);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/adds", produces = "application/json")
    public ResponseEntity<String> addDeliveryPersons(@RequestBody Collection<DeliveryPerson> deliveryPersons) {
        try {
            deliveryPersonService.addDeliveryPersons((List<DeliveryPerson>) deliveryPersons);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<DeliveryPerson>> getAllDeliveryPersons() {
        try {
            List<DeliveryPerson> deliveryPersons = deliveryPersonService.getAllDeliveryPerson();
            return new ResponseEntity<>(deliveryPersons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/get", produces = "application/json")
    public ResponseEntity<DeliveryPerson> getDeliveryPerson(long deliveryPersonId) {
        try {
            DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPerson(deliveryPersonId);
            return new ResponseEntity<>(deliveryPerson, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
