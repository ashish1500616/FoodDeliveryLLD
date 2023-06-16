package managers;

import data.CartItem;
import data.Order;
import data.OrderStatus;
import data.User;
import database.DataAccessor;
import factory.PermissionFactory;
import permission.Permission;

import java.util.List;

public class OrderManager {
    public Order placeOrder(User user, List<CartItem> cartItems) {
        Permission permission = PermissionFactory.getPlaceOrderPermission(user);
        if (!permission.isPermitted()) {
            throw new RuntimeException("Permission Denied.!!!");
        }
        CartManager cartManager = new CartManager();
        List<CartItem> userCart = cartManager.getUserCart(user);
        int order_id = DataAccessor.createOrder(user, userCart);
        cartManager.checkOutUserCart(user);
        return new Order(cartItems, order_id, user.getId(), OrderStatus.ORDER_PLACED);
    }

    public List<Order> getOrders(User user) {
        return null;
    }

    public Order getOrder(int orderId) {
        return null;
    }

    public void setOrderStatus(User user, Order order) {
        // TODO: NOTE: Since for every orderStatus state has to be handled differently - Implement State Design Pattern;
        // this code should make operations based on different order status behaviour.
        Permission permission = PermissionFactory.getUpdateOrderPermission(user);
        if (!permission.isPermitted()) {
            // sanity checks
            throw new RuntimeException("Permission Denied.");
        }
        // for ex.
        if (!order.getOrderStatus().equals(OrderStatus.ORDER_PLACED)) {
            throw new RuntimeException("Only Paced Order status can be move to cooking.");
        }
    }

}

/* TODO : Add functions
        - UpdateOrder
        - CancelOrder
*/
