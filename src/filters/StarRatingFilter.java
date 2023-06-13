package filters;

import data.FoodItem;
import data.StarRating;

public class StarRatingFilter implements FoodItemFilter {
    private final StarRating rating;

    public StarRatingFilter(StarRating rating) {
        this.rating = rating;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        if (foodItem.getStarRating().isPresent()) {
            return foodItem.getStarRating().get().getVal() >= rating.getVal();
        }
        return false;
    }
}
