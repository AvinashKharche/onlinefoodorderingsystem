package org.nyu.onlinefoodorderingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "restaurant_owner")
@Builder
@NoArgsConstructor
public class RestaurantOwner {

    @Id
    @Column(name = "restaurant_owner_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantOwnerId;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "phone", nullable = false, length = 45, unique = true)
    private String phone;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getRestaurantOwnerId() {
        return restaurantOwnerId;
    }

    public void setRestaurantOwnerId(Long restaurantOwnerId) {
        this.restaurantOwnerId = restaurantOwnerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
