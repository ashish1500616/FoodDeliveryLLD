package database;

import data.CartItem;
import data.FoodItem;
import data.Restaurant;

import java.util.List;

public class DataAccessObjectConverter {

    private DataAccessObjectConverter() {
    }

    public static List<Restaurant> convertToRestaurants(DataAccessResult dataAccessResult) {
        return null;
    }

    public static List<FoodItem> convertToFoodItems(DataAccessResult dataAccessResult) {
        return null;
    }

    public static List<CartItem> convertToCartItems(DataAccessResult cartByUser) {
        return null;
    }
}
