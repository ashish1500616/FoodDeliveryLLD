import data.CuisineType;
import data.FoodItem;
import data.MealType;
import data.StarRating;

public class Main {
    public static void main(String[] args) {
        System.out.println("LLD - Food Delivery System!");
        FoodItem foodItem = new FoodItem.FoodItemBuilder(1, "Caesar Salad", 350)
                .restaurantId(123)
                .isAvailable(true)
                .description("Delicious caesar salad with lettuce, tomato, and cheese")
                .mealType(MealType.VEG)
                .cuisineType(CuisineType.GREEK)
                .starRating(StarRating.FIVE)
                .build();
        if (foodItem.getDescription().isPresent()) {
            System.out.println(foodItem.getDescription().get());
        }
    }
}

/*
    Approach : Objective is to write maintainable and tested code therefore ignoring sum of the system constraints in the real world.
               However, it is important to note that the behavior of the system may vary in different real-world scenarios..
         - Generic Searcher: Implemented as FoodItemSearcherAPI.
         - Returns filtered FoodItems based on applied filters such as MealType, Stars, and Cuisines.
         - Designed to support the addition of new filters without requiring extensive modifications, aligning with the open-closed principle.
         - Utilizes FoodItemFilter interface, which is implemented by FoodItem class, allowing for customizable filtering based on specific criteria.
 */