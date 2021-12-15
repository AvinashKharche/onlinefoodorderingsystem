package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.Cart;

import java.util.NoSuchElementException;

public interface CartService {

    Cart getCartById(long cartId) throws NoSuchElementException;

    void addToCart(Cart cart, long userId, long foodItemId, int count);
}
