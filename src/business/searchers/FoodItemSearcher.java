package business.searchers;

import data.FoodItem;
import database.DataAccessObjectConverter;
import database.DataAccessResult;
import database.DataAccessor;
import filters.FoodItemFilter;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcher {
    public List<FoodItem> searchByName(String foodItemName, List<FoodItemFilter> foodItemFilters) {
        if (foodItemName == null || foodItemName.isEmpty() || foodItemFilters == null) {
            throw new IllegalArgumentException();
        }

        // TODO: To be implemented in future versions
        DataAccessResult dataAccessResult = DataAccessor.getFoodItemWithName(foodItemName);
        List<FoodItem> foodItems = DataAccessObjectConverter.convertToFoodItems(dataAccessResult);

        // Stream Implementation.
        // List<FoodItem> filteredFoodFromStream = foodItems.stream()
        // filter(foodItem -> foodItemFilters.stream().allMatch(filter -> filter.filter(foodItem))).toList();

        List<FoodItem> filteredFoodItems = new ArrayList<>();
        // Basic Loop Implementation.
        for (FoodItemFilter filter : foodItemFilters) {
            for (FoodItem foodItem : foodItems) {
                if (filter.filter(foodItem)) {
                    filteredFoodItems.add(foodItem);
                }
            }
        }
        return filteredFoodItems;
    }

    public FoodItem searchById(int id) {
        // TODO: Implement this.
        return null;
    }
}
