package filters;

import data.CuisineType;
import data.FoodItem;
import data.Restaurant;

import java.util.List;

public class CuisineTypeFilter implements FoodItemFilter, RestaurantFilter {
    private final List<CuisineType> cuisineTypes;

    public CuisineTypeFilter(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        //  To check if foodItem cuisines is one among the list or not.
        if (foodItem.getCuisineType().isPresent()) {
            return cuisineTypes.contains(foodItem.getCuisineType().get());
        }
        return false;
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        if (restaurant.getCuisineType().isPresent()) {
            return this.cuisineTypes.contains(restaurant.getCuisineType().get());
        }
        return false;
    }
}
