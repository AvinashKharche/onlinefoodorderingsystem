package org.nyu.onlinefoodorderingsystem.controller;

import org.nyu.onlinefoodorderingsystem.model.Discount;
import org.nyu.onlinefoodorderingsystem.service.DiscountService;
import org.nyu.onlinefoodorderingsystem.service.DiscountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<String> addCustomer(@RequestBody Discount discount) {
        try {
            discountService.addDiscount(discount);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/adds", produces = "application/json")
    public ResponseEntity<String> addCustomers(@RequestBody Collection<Discount> discounts) {
        try {
            discountService.addDiscounts((List<Discount>) discounts);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<Discount>> getAllDiscounts() {
        try {
            List<Discount> discounts = discountService.getAllDiscount();
            return new ResponseEntity<>(discounts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/get", produces = "application/json")
    public ResponseEntity<Discount> getDiscount(long discountId) {
        try {
            Discount discount = discountService.getDiscount(discountId);
            return new ResponseEntity<>(discount, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
