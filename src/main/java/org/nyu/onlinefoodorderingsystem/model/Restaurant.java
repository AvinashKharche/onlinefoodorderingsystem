package org.nyu.onlinefoodorderingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "restaurant")
@Builder
@NoArgsConstructor
public class Restaurant {

    @Id
    @Column(name = "restaurant_id", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "phone", nullable = true, length = 45, unique = true)
    private String phone;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "website", length = 50, unique = true)
    private String website;

    @Column(name = "description", nullable = true, length = 256)
    private String description;

    @Column(name = "created_date", nullable = true)
    private Timestamp createdDate;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Position> position = new HashSet<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FoodItem> foodItems = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    @Column(name = "rating", nullable = true)
    private Byte rating;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private RestaurantOwner restaurantOwner;

    public RestaurantOwner getRestaurantOwner() {
        return restaurantOwner;
    }

    public void setRestaurantOwner(RestaurantOwner restaurantOwner) {
        this.restaurantOwner = restaurantOwner;
    }

    public Byte getRating() {
        return rating;
    }

    public void setRating(Byte rating) {
        this.rating = rating;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Position> getPosition() {
        return position;
    }

    public void setPosition(Set<Position> position) {
        this.position = position;
    }

    public Set<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(Set<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public void addAddresses(Address address) {
        addresses.add(address);
        address.setRestaurant(this);
    }

    public void removeAddresses(Address address) {
        addresses.remove(address);
        address.setRestaurant(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant restraunt = (Restaurant) o;
        return getRestaurantId() == restraunt.getRestaurantId() && Objects.equals(getEmail(), restraunt.getEmail()) && Objects.equals(getWebsite(), restraunt.getWebsite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRestaurantId(), getEmail(), getWebsite());
    }
}
