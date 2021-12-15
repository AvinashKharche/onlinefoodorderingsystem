package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.Cart;
import org.nyu.onlinefoodorderingsystem.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCartById(long cartId) throws NoSuchElementException {
        Optional<Cart> optional = cartRepository.findById(cartId);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NoSuchElementException();
    }

    @Override
    public void addToCart(Cart cart, long userId, long foodItemId, int count) {
        //todo
    }
}
