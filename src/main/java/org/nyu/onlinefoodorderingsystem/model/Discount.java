package org.nyu.onlinefoodorderingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "discount")
@Builder
@NoArgsConstructor
public class Discount {

    @Id
    @Column(name = "discount_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    @Column(name = "max_discount_amt", nullable = false)
    private Byte maxDiscountAmount;

    @Column(name = "discount_percentage", nullable = false)
    private Byte discountPercentage;

    @ManyToMany(mappedBy = "discounts")
    @JsonIgnore
    private Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "discount", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Position> position = new HashSet<>();

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Byte getMaxDiscountAmount() {
        return maxDiscountAmount;
    }

    public void setMaxDiscountAmount(Byte maxDiscountAmount) {
        this.maxDiscountAmount = maxDiscountAmount;
    }

    public Byte getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Byte discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discount)) return false;
        Discount discount = (Discount) o;
        return getDiscountId() == discount.getDiscountId();
    }

    public Set<Position> getPosition() {
        return position;
    }

    public void setPosition(Set<Position> position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiscountId());
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
