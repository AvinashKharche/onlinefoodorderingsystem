package org.nyu.onlinefoodorderingsystem.controller;

import org.nyu.onlinefoodorderingsystem.model.FoodItem;
import org.nyu.onlinefoodorderingsystem.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fooditem")
public class FoodItemController {
    @Autowired
    private FoodItemService itemService;

    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<String> addFoodItem(@RequestBody Map<String, Object> foodItemMap) {
        try {
            Map<String, Object> map = (Map<String, Object>) foodItemMap.get("foodItem");
            FoodItem foodItem = new FoodItem();
            Integer rating = (Integer) map.get("rating");
            foodItem.setRating(rating.byteValue());
            foodItem.setCalories((int) map.get("calories"));
            foodItem.setName((String) map.get("name"));
            foodItem.setPrice((double) map.get("price"));

            itemService.addFoodItemToARestaurant(foodItem, ((Integer) foodItemMap.get("restaurantId")).longValue(), (String) foodItemMap.get("cuisineName"));
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/adds", produces = "application/json")
    public ResponseEntity<String> addFoodItems(@RequestBody Map<String, Object> foodItemMap) {
        try {
            List<Map<String, Object>> foodListMap = (List<Map<String, Object>>) foodItemMap.get("foodItem");
            List<FoodItem> foodItems = new ArrayList<>();
            for (Map<String, Object> foodItem : foodListMap) {
                FoodItem foodItem1 = new FoodItem();
                Integer rating = (Integer) foodItem.get("rating");
                foodItem1.setRating(rating.byteValue());
                foodItem1.setCalories((int) foodItem.get("calories"));
                foodItem1.setName((String) foodItem.get("name"));
                foodItem1.setPrice((double) foodItem.get("price"));
                foodItems.add(foodItem1);
            }

            itemService.addFoodItemsToARestaurant(foodItems, ((Integer) foodItemMap.get("restaurantId")).longValue(), (String) foodItemMap.get("cuisineName"));
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
