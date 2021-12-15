package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.FoodItem;

import java.util.List;
import java.util.Set;

public interface FoodItemService {

    void addFoodItemToARestaurant(FoodItem foodItem, long restaurantId, String cuisine);

    void addFoodItemToACart(FoodItem foodItem, long cartId);

    Set<FoodItem> getFoodItemsByCuisine(String cuisine);

    void addFoodItemsToARestaurant(List<FoodItem> foodItems, long restaurantId, String cuisine);
}
