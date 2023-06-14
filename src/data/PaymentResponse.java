package data;

public class PaymentResponse {
    private final int amount;
    private final int id;
    private PaymentStatus paymentStatus;

    public PaymentResponse(PaymentStatus paymentStatus, int amount, int id) {
        this.paymentStatus = paymentStatus;
        this.amount = amount;
        this.id = id;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public int getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }
}
