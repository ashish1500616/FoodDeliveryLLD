package permission;

import business.searchers.RestaurantSearcher;
import data.FoodItem;
import data.Restaurant;
import data.User;
import managers.DeliveryManager;

public class AddToCartPermission implements Permission {
    private final User user;
    private final FoodItem foodItem;

    private final DeliveryManager deliveryManager;

    public AddToCartPermission(User user, FoodItem foodItem) {
        this.user = user;
        this.foodItem = foodItem;
        // Note : not injecting as usual.
        this.deliveryManager = new DeliveryManager();
    }

    @Override
    public boolean isPermitted() {
        if (!foodItem.isAvailable()) {
            return false;
        }
        Restaurant restaurant = new RestaurantSearcher().searchById(foodItem.getRestaurantId());
        /*
            Using restaurant address and user address,
            there should be sanity check if the user is processing a valid request and trying to place the order
            to nearby restaurant.

            restaurant.getAddress();
         */
        return false;
    }
}
