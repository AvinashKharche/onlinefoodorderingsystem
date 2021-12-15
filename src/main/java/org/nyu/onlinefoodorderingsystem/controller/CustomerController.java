package org.nyu.onlinefoodorderingsystem.controller;

import org.nyu.onlinefoodorderingsystem.model.Customer;
import org.nyu.onlinefoodorderingsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        try {
            customerService.addCustomer(customer);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/adds", produces = "application/json")
    public ResponseEntity<String> addCustomers(@RequestBody Collection<Customer> customers) {
        try {
            customerService.addCustomers((List<Customer>) customers);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerService.getAllCustomer();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/get", produces = "application/json")
    public ResponseEntity<Customer> getCustomer(Long customerId) {
        try {
            Customer customer = customerService.getCustomer(customerId);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
