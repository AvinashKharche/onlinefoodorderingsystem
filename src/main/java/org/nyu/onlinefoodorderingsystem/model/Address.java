package org.nyu.onlinefoodorderingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "address")
@Builder
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(name = "apartment_no", nullable = false, length = 45)
    private String apartmentNo;

    @Column(name = "street", nullable = false, length = 45)
    private String street;

    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @Column(name = "zip_code", nullable = false, length = 45)
    private String zipCode;

    @Column(name = "country", nullable = false, length = 45)
    private String country;

    @ManyToMany(mappedBy = "addresses")
    @JsonIgnore
    private Set<Customer> customers = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    @OneToMany(
            mappedBy = "sourceAddress",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Delivery> deliveries = new ArrayList<>();

    @OneToMany(mappedBy = "sourceAddress")
    private Set<Delivery> sourceAddress;

    @OneToMany(mappedBy = "destinationAddress")
    private Set<Delivery> destinationAddress;

    public Address() {
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }


    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public Set<Delivery> getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(Set<Delivery> sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public Set<Delivery> getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(Set<Delivery> destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getAddressId(), address.getAddressId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressId());
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", apartmentNo='" + apartmentNo + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", customers=" + customers +
                ", restaurant=" + restaurant +
                ", deliveries=" + deliveries +
                ", sourceAddress=" + sourceAddress +
                ", destinationAddress=" + destinationAddress +
                '}';
    }
}
