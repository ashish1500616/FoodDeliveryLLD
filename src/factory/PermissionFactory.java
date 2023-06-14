package factory;

import data.FoodItem;
import data.User;
import permission.AddToCartPermission;
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
}
