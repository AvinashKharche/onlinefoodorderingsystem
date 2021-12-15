package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.Discount;
import org.nyu.onlinefoodorderingsystem.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public void addDiscount(Discount discount) {
        discountRepository.save(discount);
    }

    public void addDiscounts(List<Discount> discounts) {
        discountRepository.saveAll(discounts);
    }

    public List<Discount> getAllDiscount() {
        return discountRepository.findAll();
    }

    public Discount getDiscount(long discountId) {
        Optional<Discount> optional = discountRepository.findById(discountId);
        if (optional.isPresent()) return optional.get();
        throw new NoSuchElementException();
    }
}
