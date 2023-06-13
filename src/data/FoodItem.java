package data;

import java.util.Optional;

public class FoodItem {
    private final int id;
    private final String name;
    private final double price;
    private final int restaurantId;
    private final boolean isAvailable;
    private final Optional<String> description;
    private final Optional<MealType> mealType;
    private final Optional<CuisineType> cuisineType;
    private final Optional<StarRating> starRating;

    private FoodItem(FoodItemBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.restaurantId = builder.restaurantId;
        this.isAvailable = builder.isAvailable;
        this.description = builder.description;
        this.mealType = builder.mealType;
        this.cuisineType = builder.cuisineType;
        this.starRating = builder.starRating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Optional<String> getDescription() {
        return description;
    }

    public Optional<MealType> getMealType() {
        return mealType;
    }

    public Optional<CuisineType> getCuisineType() {
        return cuisineType;
    }

    public Optional<StarRating> getStarRating() {
        return starRating;
    }

    public static class FoodItemBuilder {
        private final int id;
        private final String name;
        private final double price;
        private int restaurantId;
        private boolean isAvailable;
        private Optional<String> description = Optional.empty();
        private Optional<MealType> mealType = Optional.empty();
        private Optional<CuisineType> cuisineType = Optional.empty();
        private Optional<StarRating> starRating = Optional.empty();

        public FoodItemBuilder(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public FoodItemBuilder restaurantId(int restaurantId) {
            this.restaurantId = restaurantId;
            return this;
        }

        public FoodItemBuilder isAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public FoodItemBuilder description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        public FoodItemBuilder mealType(MealType mealType) {
            this.mealType = Optional.ofNullable(mealType);
            return this;
        }

        public FoodItemBuilder cuisineType(CuisineType cuisineType) {
            this.cuisineType = Optional.ofNullable(cuisineType);
            return this;
        }

        public FoodItemBuilder starRating(StarRating starRating) {
            this.starRating = Optional.ofNullable(starRating);
            return this;
        }

        public FoodItem build() {
            return new FoodItem(this);
        }
    }
}
