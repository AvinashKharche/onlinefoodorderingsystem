package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.Restaurant;

import java.util.List;
import java.util.NoSuchElementException;

public interface RestaurantService {
    void addRestaurant(Restaurant restaurant);

    void addRestaurants(List<Restaurant> restaurants);

    Restaurant getRestaurantById(long restaurantId) throws NoSuchElementException;

    List<Restaurant> getAllRestaurants();
}
