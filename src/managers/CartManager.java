package managers;

import data.CartItem;
import data.FoodItem;
import data.User;
import database.DataAccessor;
import factory.PermissionFactory;
import permission.Permission;

import java.util.List;

public class CartManager {

    public List<CartItem> getUserCart(User user) {
        return List.of();
    }

    public void addItemToCart(User user, FoodItem foodItem) {
        Permission addToCartPermission = PermissionFactory.getAddToCartPermission(user, foodItem);
        if (!addToCartPermission.isPermitted()) {
            throw new RuntimeException("Permission Denied !!!");
        }
        if (!isFoodItemFromSameRestaurant(user, foodItem)) {
            throw new RuntimeException("Your cart contains items from diff restaurant.");
        }
        // Perform data layer operations.
        DataAccessor.addItemToCart(user, foodItem);
        return;
    }

    public void deleteItemFromCart(User user, FoodItem foodItem) {

    }

    public void checkoutUserCart(User user) {

    }

    private boolean isFoodItemFromSameRestaurant(User user, FoodItem foodItem) {
        List<CartItem> userCart = getUserCart(user);
        if (!userCart.isEmpty()) {
            return userCart.get(0).getFoodItem().getRestaurantId() == foodItem.getRestaurantId();
        }
        return false;
    }


}
/* Cart.
     id, user_id, food_item_id, qty, status
     permission - only authorised users are allowed to add item to cart.
     System : - Diff level of success
     R,W,RW,,REX , etc.
     Permission: abstract
     User , Permission
 */