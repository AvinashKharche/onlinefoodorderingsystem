package org.nyu.onlinefoodorderingsystem.service;

import org.nyu.onlinefoodorderingsystem.model.Discount;

import java.util.List;

public interface DiscountService {
    void addDiscount(Discount discount);

    void addDiscounts(List<Discount> discounts);

    List<Discount> getAllDiscount();

    Discount getDiscount(long discountId);
}
