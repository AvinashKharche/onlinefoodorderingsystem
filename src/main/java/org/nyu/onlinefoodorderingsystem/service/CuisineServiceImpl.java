package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.Cuisine;
import org.nyu.onlinefoodorderingsystem.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CuisineServiceImpl implements CuisineService {

    @Autowired
    private CuisineRepository cuisineRepository;

    @Override
    public Cuisine getCuisineIdByName(String cuisine) {
        Optional<Cuisine> cuisineOptional = cuisineRepository.findAll().stream().filter(x -> x.getName().equalsIgnoreCase(cuisine)).findFirst();
        if (cuisineOptional.isPresent()) {
            return cuisineOptional.get();
        }
        return null;
    }
}
