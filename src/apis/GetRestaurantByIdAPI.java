package apis;

import business.searchers.RestaurantSearcher;
import data.Restaurant;

public class GetRestaurantByIdAPI {
    public Restaurant getRestaurant(int restaurantId) {
        // Perform sanity check.
        if (restaurantId < 0) {
            throw new IllegalArgumentException();
        }
        return new RestaurantSearcher().searchById(restaurantId);
    }
}
