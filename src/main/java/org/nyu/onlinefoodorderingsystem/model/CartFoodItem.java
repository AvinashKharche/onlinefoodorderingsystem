package org.nyu.onlinefoodorderingsystem.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartFoodItem implements Serializable {

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "food_item_id")
    private Long foodItemId;

    public CartFoodItem() {
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartFoodItem)) return false;
        CartFoodItem that = (CartFoodItem) o;
        return Objects.equals(getCartId(), that.getCartId()) && Objects.equals(getFoodItemId(), that.getFoodItemId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCartId(), getFoodItemId());
    }
}