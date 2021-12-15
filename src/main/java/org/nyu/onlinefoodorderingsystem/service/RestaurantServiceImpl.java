package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.Restaurant;
import org.nyu.onlinefoodorderingsystem.repository.CuisineRepository;
import org.nyu.onlinefoodorderingsystem.repository.RestrauntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestrauntRepository restrauntRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    public void addRestaurant(Restaurant restaurant) {
        restaurant.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        restaurant.getAddresses().stream().forEach(x -> x.setRestaurant(restaurant));
        restaurant.getRestaurantOwner().setCreatedDate(new Timestamp(System.currentTimeMillis()));
        restaurant.getRestaurantOwner().setRestaurant(restaurant);
        if (restaurant.getFoodItems() != null)
            restaurant.getFoodItems().stream().forEach(x -> x.setRestaurant(restaurant));
        restrauntRepository.save(restaurant);
    }

    public void addRestaurants(List<Restaurant> restaurants) {
        for(Restaurant restaurant:restaurants) {
            addRestaurant(restaurant);
        }
    }

    @Override
    public Restaurant getRestaurantById(long restaurantId) throws NoSuchElementException {
        Optional<Restaurant> optional = restrauntRepository.findById(restaurantId);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NoSuchElementException();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = restrauntRepository.findAll();
        return restaurants;
    }
}
