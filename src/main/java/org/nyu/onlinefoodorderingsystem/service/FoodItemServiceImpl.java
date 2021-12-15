package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.Cart;
import org.nyu.onlinefoodorderingsystem.model.Cuisine;
import org.nyu.onlinefoodorderingsystem.model.FoodItem;
import org.nyu.onlinefoodorderingsystem.model.Restaurant;
import org.nyu.onlinefoodorderingsystem.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private FoodItemRepository itemRepository;

    @Autowired
    private CuisineService cuisineService;

    @Autowired
    private CartService cartService;

    @Override
    public void addFoodItemToARestaurant(FoodItem foodItem, long restaurantId, String cuisine) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        if (restaurant != null) {
            if (foodItem.getImageId() == null) {
                foodItem.setImageId(UUID.randomUUID().toString());
            }
            Cuisine cuisine1 = cuisineService.getCuisineIdByName(cuisine);
            foodItem.setCuisine(cuisine1);
            foodItem.setRestaurant(restaurant);
            itemRepository.save(foodItem);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void addFoodItemsToARestaurant(List<FoodItem> foodItems, long restaurantId, String cuisine) {
        for (FoodItem foodItem : foodItems) {
            addFoodItemToARestaurant(foodItem, restaurantId, cuisine);
        }
    }

    @Override
    public void addFoodItemToACart(FoodItem foodItem, long cartId) {
        Cart cart = cartService.getCartById(cartId);
    }

    @Override
    public Set<FoodItem> getFoodItemsByCuisine(String cuisine) {
        return itemRepository.findAll().stream().filter(x -> x.getCuisine() != null).filter(x -> x.getCuisine().getName().equalsIgnoreCase(cuisine)).collect(Collectors.toSet());
    }
}
