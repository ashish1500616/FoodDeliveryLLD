package filters;

import data.FoodItem;
import data.MealType;
import data.Restaurant;

public class MealTypeFilter implements FoodItemFilter, RestaurantFilter {

    private final MealType mealType;

    public MealTypeFilter(MealType mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        if (foodItem.getMealType().isPresent()) {
            return foodItem.getMealType().get().equals(mealType);
        }
        return false;
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        if (restaurant.getMealType().isPresent()) {
            return restaurant.getMealType().get().equals(mealType);
        }
        return false;
    }
}
