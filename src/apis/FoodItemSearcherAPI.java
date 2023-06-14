package apis;

import business.searchers.FoodItemSearcher;
import data.CuisineType;
import data.FoodItem;
import data.MealType;
import data.StarRating;
import filters.CuisineTypeFilter;
import filters.FoodItemFilter;
import filters.MealTypeFilter;
import filters.StarRatingFilter;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcherAPI {
    public List<FoodItem> searchFoodItems(String foodItemName,
                                          MealType mealType,
                                          List<CuisineType> cuisines,
                                          StarRating starRatings) {
        List<FoodItemFilter> foodItemFilters = new ArrayList<>();
        // TODO : Implement Factory Pattern to create these objects
        if (mealType != null) {
            foodItemFilters.add(new MealTypeFilter(mealType));
        }
        if (cuisines != null && !cuisines.isEmpty()) {
            foodItemFilters.add(new CuisineTypeFilter(cuisines));
        }
        if (starRatings != null) {
            foodItemFilters.add(new StarRatingFilter(starRatings));
        }
        return new FoodItemSearcher().searchByName(foodItemName, foodItemFilters);
    }
}
