package managers;

import data.PaymentResponse;

public class NetBankingPaymentManager implements PaymentManager {
    private final String bankName;
    private final String userName;
    private final String passWord;
    private final String pin;

    public NetBankingPaymentManager(NetBankingPaymentManagerBuilder builder) {
        this.bankName = builder.bankName;
        this.userName = builder.userName;
        this.passWord = builder.passWord;
        this.pin = builder.pin;
    }

    @Override
    public PaymentResponse executePayment() {
        return null;
    }

    public static class NetBankingPaymentManagerBuilder {
        private String bankName;
        private String userName;
        private String passWord;
        private String pin;

        public NetBankingPaymentManagerBuilder bankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public NetBankingPaymentManagerBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public NetBankingPaymentManagerBuilder passWord(String passWord) {
            this.passWord = passWord;
            return this;
        }

        public NetBankingPaymentManagerBuilder pin(String pin) {
            this.pin = pin;
            return this;
        }

        public NetBankingPaymentManager build() {
            return new NetBankingPaymentManager(this);
        }

    }
}
