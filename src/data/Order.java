package data;

import java.util.List;

public class Order {
    private final List<CartItem> cartItemList;
    private final int orderId;
    private final int userId;
    private final OrderStatus orderStatus;

    public Order(List<CartItem> cartItemList, int orderId, int userId, OrderStatus orderStatus) {
        this.cartItemList = cartItemList;
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}

