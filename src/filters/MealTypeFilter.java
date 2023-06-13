package filters;

import data.FoodItem;
import data.MealType;

public class MealTypeFilter implements FoodItemFilter {

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
}
