package apis;

import business.searchers.RestaurantSearcher;
import data.CuisineType;
import data.MealType;
import data.Restaurant;
import data.StarRating;
import filters.CuisineTypeFilter;
import filters.MealTypeFilter;
import filters.RestaurantFilter;
import filters.StarRatingFilter;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearcherAPI {
    public List<Restaurant> searchRestaurants(String restaurantName, MealType mealType, List<CuisineType> cuisines, StarRating starRatings) {
        List<RestaurantFilter> restaurantFilters = new ArrayList<>();
        if (mealType != null) {
            restaurantFilters.add(new MealTypeFilter(mealType));
        }
        if (cuisines != null && !cuisines.isEmpty()) {
            restaurantFilters.add(new CuisineTypeFilter(cuisines));
        }
        if (starRatings != null) {
            restaurantFilters.add(new StarRatingFilter(starRatings));
        }
        return new RestaurantSearcher().search(restaurantName, restaurantFilters);
    }
}
