package managers;

import data.PaymentResponse;

public class CardBasedPaymentManager implements PaymentManager {
    private final String id;
    private final String cardNumber;
    private final String cardExpiry;
    private final String cardCVV;

    public CardBasedPaymentManager(CardBasedPaymentManagerBuilder builder) {
        this.id = builder.id;
        this.cardNumber = builder.cardNumber;
        this.cardExpiry = builder.cardExpiry;
        this.cardCVV = builder.cardCVV;
    }

    @Override
    public PaymentResponse executePayment() {
        return null;
    }

    public static class CardBasedPaymentManagerBuilder {

        private String id;
        private String cardNumber;
        private String cardExpiry;
        private String cardCVV;

        public CardBasedPaymentManagerBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CardBasedPaymentManagerBuilder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public CardBasedPaymentManagerBuilder cardExpiry(String cardExpiry) {
            this.cardExpiry = cardExpiry;
            return this;
        }

        public CardBasedPaymentManagerBuilder cardCVV(String cardCVV) {
            this.cardExpiry = cardCVV;
            return this;
        }

        public CardBasedPaymentManager build() {
            return new CardBasedPaymentManager(this);
        }

    }
}
