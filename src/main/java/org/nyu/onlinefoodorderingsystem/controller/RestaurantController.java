package org.nyu.onlinefoodorderingsystem.controller;

import org.nyu.onlinefoodorderingsystem.model.Restaurant;
import org.nyu.onlinefoodorderingsystem.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<String> addRestaurant(@RequestBody Restaurant restaurant) {
        try {
            restaurantService.addRestaurant(restaurant);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/adds", produces = "application/json")
    public ResponseEntity<String> addRestaurants(@RequestBody Collection<Restaurant> restaurants) {
        try {
            restaurantService.addRestaurants((List<Restaurant>)restaurants);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        try {
            List<Restaurant> restaurants = restaurantService.getAllRestaurants();
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
