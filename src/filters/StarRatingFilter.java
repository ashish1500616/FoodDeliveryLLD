package filters;

import data.FoodItem;
import data.Restaurant;
import data.StarRating;

public class StarRatingFilter implements FoodItemFilter, RestaurantFilter {
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

    @Override
    public boolean filter(Restaurant restaurant) {
        if (restaurant.getStarRating().isPresent()) {
            return restaurant.getStarRating().get().getVal() >= rating.getVal();
        }
        return false;
    }
}
