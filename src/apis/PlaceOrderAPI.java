package apis;

import data.*;
import factory.PaymentManagerFactory;
import managers.CartManager;
import managers.OrderManager;
import managers.PaymentManager;
import managers.UserManager;

public class PlaceOrderAPI {
    private final UserManager userManager = new UserManager();
    private final OrderManager orderManager = new OrderManager();

    public Order placeOrder(String userToken, PaymentInfo paymentInfo, PaymentMode paymentMode) {
        if (userToken == null || userToken.isEmpty()) {
            throw new IllegalArgumentException("Params missing.!!");
        }
        User user = userManager.getUserByToken(userToken);
        if (user == null) {
            throw new IllegalArgumentException("UserToken is invalid");
        }
        PaymentManager paymentManager = PaymentManagerFactory.getPaymentManager(paymentMode, paymentInfo);
        PaymentResponse paymentResponse = paymentManager.executePayment();
        if (paymentResponse == null || paymentResponse.getPaymentStatus().equals(PaymentStatus.FAILED)) {
            throw new RuntimeException("Payment Failed");
        } else {
            orderManager.placeOrder(user, new CartManager().getUserCart(user));
        }
        return null;
    }
}
