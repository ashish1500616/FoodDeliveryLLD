package apis;

import business.searchers.FoodItemSearcher;
import data.FoodItem;

public class GetFoodItemByIdAPI {
    public FoodItem getFoodItem(int foodItemId) {
        // Perform sanity checks.
        if (foodItemId < 0) {
            throw new IllegalArgumentException();
        }
        return new FoodItemSearcher().searchById(foodItemId);
    }
}
