package org.nyu.onlinefoodorderingsystem.model;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "cart_details")
@Builder
public class CartDetails {

    @EmbeddedId
    private CartFoodItem id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cartId")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("foodItemId")
    private FoodItem foodItem;

    @Column(name = "food_item_count")
    private int foodItemCount;

    public CartDetails() {
    }

    public CartFoodItem getId() {
        return id;
    }

    public void setId(CartFoodItem id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public int getFoodItemCount() {
        return foodItemCount;
    }

    public void setFoodItemCount(int foodItemCount) {
        this.foodItemCount = foodItemCount;
    }
}