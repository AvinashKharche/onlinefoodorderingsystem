package org.nyu.onlinefoodorderingsystem.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "position_details")
@Builder
@NoArgsConstructor
public class PositionDetails {

    @EmbeddedId
    private PositionFoodItem id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("positionId")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("foodItemId")
    private FoodItem foodItem;

    @Column(name = "food_item_count")
    private int foodItemCount;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position cart) {
        this.position = cart;
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

    public PositionFoodItem getId() {
        return id;
    }

    public void setId(PositionFoodItem id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionDetails)) return false;
        PositionDetails that = (PositionDetails) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}