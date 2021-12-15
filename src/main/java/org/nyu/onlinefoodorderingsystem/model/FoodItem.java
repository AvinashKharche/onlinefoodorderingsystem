package org.nyu.onlinefoodorderingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food_item")
@Builder
@NoArgsConstructor
public class FoodItem implements Serializable {

    @Id
    @Column(name = "food_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodItemId;

    @Column(name = "price", nullable = false, precision = 5, scale = 2)
    private Double price;

    @Column(name = "calories", nullable = false)
    private Integer calories;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "rating", nullable = true)
    private Byte rating;

    @Column(name = "img_id", nullable = false)
    private String imageId;

    @OneToMany(
            mappedBy = "foodItem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private Set<CartDetails> carts = new HashSet<>();

    @OneToMany(
            mappedBy = "foodItem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private Set<PositionDetails> positions = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }

    public Set<CartDetails> getCarts() {
        return carts;
    }

    public void setCarts(Set<CartDetails> carts) {
        this.carts = carts;
    }

    public Set<PositionDetails> getPositions() {
        return positions;
    }

    public void setPositions(Set<PositionDetails> positions) {
        this.positions = positions;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getRating() {
        return rating;
    }

    public void setRating(Byte rating) {
        this.rating = rating;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}