package database;

import data.FoodItem;
import data.User;

public class DataAccessor {

    // TODO: Think and improve this class.
    private DataAccessor() {
        /*
            DataAccessor : Class to perform data level operation.
            Utility classes: Sometimes, you might have a class that provides only static
            utility methods and doesn't need to be instantiated.
            In such cases, we can define a private constructor to prevent accidental instantiation.
        */

    }

    public static DataAccessResult getRestaurantsWithName(String name) {
        return null;
    }

    public static DataAccessResult getFoodItemWithName(String name) {
        return null;
    }

    public static void addItemToCart(User user, FoodItem foodItem) {
        return;
    }

    public static DataAccessResult getCartByUser(User user) {
        return null;
    }

    public static void checkOutCart(User user) {
    }
}
