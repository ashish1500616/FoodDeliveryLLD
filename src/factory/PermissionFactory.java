package factory;

import data.FoodItem;
import data.User;
import permission.AddToCartPermission;
import permission.CheckoutCartPermission;
import permission.DeleteFromCartPermission;
import permission.Permission;

public class PermissionFactory {

    private PermissionFactory() {
    }

    public static Permission getAddToCartPermission(User user, FoodItem foodItem) {
        return new AddToCartPermission(user, foodItem);
    }

    public static Permission getDeleteFromCartPermission(User user, FoodItem foodItem) {
        return new DeleteFromCartPermission(user, foodItem);
    }

    public static Permission getCheckoutFromCartPermission(User user) {
        return new CheckoutCartPermission(user);
    }
}
