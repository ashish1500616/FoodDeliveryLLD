package data;

public class CartItem {
    private final FoodItem foodItem;
    private final int quanity;

    public CartItem(FoodItem foodItem, int quanity) {
        this.foodItem = foodItem;
        this.quanity = quanity;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public int getQuanity() {
        return quanity;
    }
}
