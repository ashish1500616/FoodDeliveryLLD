package apis;

import data.Order;
import data.OrderStatus;
import factory.PermissionFactory;
import managers.OrderManager;
import managers.UserManager;
import permission.Permission;

public class UpdateOrderAPI {
    private final UserManager userManager = new UserManager();
    private final OrderManager orderManager = new OrderManager();

    public void updateOrder(String userToken, OrderStatus orderStatus, int orderId) {
        Order order = orderManager.getOrder(orderId);
        if (userToken == null || userToken.isEmpty() || order == null) {
            throw new IllegalArgumentException("Invalid Request. Not Allowed.");
        }
        Permission permission = PermissionFactory.getUpdateOrderPermission(userManager.getUserByToken(userToken));
        if (!permission.isPermitted()) {
            new RuntimeException("Permission Denied.");
        }
        return;
    }
}
