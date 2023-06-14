package apis;

import business.searchers.FoodItemSearcher;
import data.FoodItem;
import data.User;
import managers.CartManager;
import managers.UserManager;

public class AddToCartAPI {
    private final UserManager userManager = new UserManager();
    private final FoodItemSearcher foodItemSearcher = new FoodItemSearcher();
    private final CartManager cartManager = new CartManager();

    public void addToCart(String userToken, int foodItemId) {
        // Sanity Checks on UserToken.
        if (userToken == null || userToken.isEmpty() || foodItemId < 0) {
            throw new IllegalArgumentException();
        }
        User currentUser = userManager.getUserByToken(userToken);
        if (currentUser == null) {
            throw new IllegalArgumentException("No User Found.");
        }
        FoodItem foodItem = foodItemSearcher.searchById(foodItemId);
        cartManager.addItemToCart(currentUser, foodItem);
    }

    public void delete(int cartId, int foodItemId) {

    }
}
