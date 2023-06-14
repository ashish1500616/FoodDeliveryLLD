package managers;

import data.CartItem;
import data.FoodItem;
import data.User;
import database.DataAccessObjectConverter;
import database.DataAccessResult;
import database.DataAccessor;
import factory.PermissionFactory;
import permission.Permission;

import java.util.List;

public class CartManager {

    public List<CartItem> getUserCart(User user) {
        DataAccessResult cartByUser = DataAccessor.getCartByUser(user);
        List<CartItem> cartItems = DataAccessObjectConverter.convertToCartItems(cartByUser);
        return cartItems;
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
        Permission deleteFromCartPermission = PermissionFactory.getDeleteFromCartPermission(user, foodItem);
        if (!deleteFromCartPermission.isPermitted()) {
            throw new RuntimeException("Deletion from this cart not allowed.");
        }
        if (!isFoodItemPresentInCart(user, foodItem)) {
            throw new RuntimeException("Fooditem not in cart.");
        }
    }

    private boolean isFoodItemPresentInCart(User user, FoodItem foodItem) {
        List<CartItem> userCart = getUserCart(user);
        return userCart.stream().anyMatch(cartItem -> cartItem.getFoodItem().getId() == foodItem.getId());
    }

    public void checkOutUserCart(User user) {
        Permission checkoutFromCartPermission = PermissionFactory.getCheckoutFromCartPermission(user);
        if (!checkoutFromCartPermission.isPermitted()) {
            throw new RuntimeException("Permission Denied !!!! . Checkout for this user is not allowed!");
        }
        if (isCartEmpty(user)) {
            throw new RuntimeException("Checkout Denied !!! , No Item in the cart.");
        }
        DataAccessor.checkOutCart(user);
    }

    private boolean isCartEmpty(User user) {
        List<CartItem> userCart = getUserCart(user);
        return userCart.isEmpty();
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
     if payment has succeeded create an order in the order table.
 */