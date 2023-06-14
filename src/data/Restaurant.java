package data;

import java.util.Optional;

public class Restaurant {
    private final int id;
    private final String name;
    private final Optional<String> address;
    private final Optional<MealType> mealType;
    private final Optional<String> description;
    private final Optional<CuisineType> cuisineType;
    private final Optional<StarRating> starRating;

    private final Optional<MenuCatalog> menuCatalog;

    private Restaurant(RestaurantBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.mealType = builder.mealType;
        this.description = builder.description;
        this.cuisineType = builder.cuisineType;
        this.starRating = builder.starRating;
        this.menuCatalog = builder.menuCatalog;
    }

    public String getName() {
        return name;
    }

    public Optional<CuisineType> getCuisineType() {
        return cuisineType;
    }

    public int getId() {
        return id;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public Optional<MealType> getMealType() {
        return mealType;
    }

    public Optional<String> getDescription() {
        return description;
    }

    public Optional<StarRating> getStarRating() {
        return starRating;
    }


    public static class RestaurantBuilder {
        private final int id;
        private final String name;
        private Optional<String> address = Optional.empty();
        private Optional<MealType> mealType = Optional.empty();
        private Optional<String> description = Optional.empty();
        private Optional<CuisineType> cuisineType = Optional.empty();
        private Optional<StarRating> starRating = Optional.empty();
        private Optional<MenuCatalog> menuCatalog = Optional.empty();

        public RestaurantBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public RestaurantBuilder address(String address) {
            this.address = Optional.ofNullable(address);
            return this;
        }

        public RestaurantBuilder mealType(MealType mealType) {
            this.mealType = Optional.ofNullable(mealType);
            return this;
        }

        public RestaurantBuilder description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        public RestaurantBuilder cuisineType(CuisineType cuisineType) {
            this.cuisineType = Optional.ofNullable(cuisineType);
            return this;
        }

        public RestaurantBuilder starRating(StarRating starRating) {
            this.starRating = Optional.ofNullable(starRating);
            return this;
        }

        public RestaurantBuilder menuCatalog(MenuCatalog menuCatalog) {
            this.menuCatalog = Optional.ofNullable(menuCatalog);
            return this;
        }

        public Restaurant build() {
            return new Restaurant(this);
        }
    }
}
