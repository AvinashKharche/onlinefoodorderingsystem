package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.Cuisine;

import java.util.NoSuchElementException;

public interface CuisineService {
    Cuisine getCuisineIdByName(String cuisine);
}
