package business.searchers;

import data.FoodItem;
import filters.FoodItemFilter;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcher {
    List<FoodItem> search(String foodItemName, List<FoodItemFilter> filters) {
        if (foodItemName == null || foodItemName.isEmpty() || filters == null) {
            throw new IllegalArgumentException();
        }

        DataAccessResult dataAccessResult = DataAccessor.getFoodItemWithName(foodItemName);
        List<FoodItem> foodItems = DataAccessObjectConverter.convertToFoodItems(dataAccessResult);

        // Stream Implementation.
        // List<FoodItem> filteredFoodFromStream = foodItems.stream()
        // filter(foodItem -> filters.stream().allMatch(filter -> filter.filter(foodItem))).toList();

        List<FoodItem> filteredFoodItems = new ArrayList<>();
        // Basic Loop Implementation.
        for (FoodItemFilter filter : filters) {
            for (FoodItem foodItem : foodItems) {
                if (filter.filter(foodItem)) {
                    filteredFoodItems.add(foodItem);
                }
            }
        }
        return filteredFoodItems;
    }
}
