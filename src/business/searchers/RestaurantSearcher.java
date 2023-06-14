package business.searchers;

import data.Restaurant;
import database.DataAccessObjectConverter;
import database.DataAccessResult;
import database.DataAccessor;
import filters.RestaurantFilter;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearcher {
    public List<Restaurant> searchByName(String restaurantName, List<RestaurantFilter> restaurantFilters) {
        if (restaurantName == null || restaurantFilters == null || restaurantName.isEmpty() || restaurantFilters.isEmpty()) {
            throw new IllegalArgumentException();
        }

        // TODO: To be implemented in future versions
        DataAccessResult dataAccessResult = DataAccessor.getRestaurantsWithName(restaurantName);
        List<Restaurant> restaurants = DataAccessObjectConverter.convertToRestaurants(dataAccessResult);

        // Stream Implementation.
        // List<Restaurant> filteredRestaurants = restaurants.stream()
        // filter(restaurant -> filters.stream().allMatch(filter -> filter.filter(restaurant))).toList();

        List<Restaurant> filteredRestaurants = new ArrayList<>();
        // Basic Loop Implementation.
        for (RestaurantFilter filter : restaurantFilters) {
            for (Restaurant restaurant : restaurants) {
                if (filter.filter(restaurant)) {
                    filteredRestaurants.add(restaurant);
                }
            }
        }
        return filteredRestaurants;
    }

    public Restaurant searchById(int id) {
        // TODO: Implement this.
        return null;
    }
}
