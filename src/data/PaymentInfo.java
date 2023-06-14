package data;

import java.util.Map;

public class PaymentInfo {
    private Map<String, String> paymentInfo;

    public PaymentInfo(Map<String, String> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Map<String, String> getPaymentInfo() {
        return paymentInfo;
    }
}
