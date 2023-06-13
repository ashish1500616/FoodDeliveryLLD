package filters;

import data.CuisineType;
import data.FoodItem;

import java.util.List;

public class CuisineTypeFilter implements FoodItemFilter {
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
}
