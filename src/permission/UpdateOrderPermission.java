package permission;

import data.User;

public class UpdateOrderPermission implements Permission {
    private final User user;
//    private final Order order;
//    private final OrderStatus orderStatus;

    public UpdateOrderPermission(User user) {
        this.user = user;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
