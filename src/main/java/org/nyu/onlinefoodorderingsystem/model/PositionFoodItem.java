package org.nyu.onlinefoodorderingsystem.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PositionFoodItem implements Serializable {

    @Column(name = "position_id", nullable = false)
    private Long positionId;

    @Column(name = "food_item_id", nullable = false)
    private Long foodItemId;

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long cartId) {
        this.positionId = cartId;
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
        if (!(o instanceof PositionFoodItem)) return false;
        PositionFoodItem that = (PositionFoodItem) o;
        return Objects.equals(getPositionId(), that.getPositionId()) && Objects.equals(getFoodItemId(), that.getFoodItemId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPositionId(), getFoodItemId());
    }
}