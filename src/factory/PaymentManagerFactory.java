package factory;

import data.PaymentInfo;
import data.PaymentMode;
import managers.CardBasedPaymentManager;
import managers.NetBankingPaymentManager;
import managers.NetBankingPaymentManager.NetBankingPaymentManagerBuilder;
import managers.PaymentManager;

import static managers.CardBasedPaymentManager.CardBasedPaymentManagerBuilder;

public class PaymentManagerFactory {

    public static PaymentManager getPaymentManager(PaymentMode paymentMode, PaymentInfo paymentInfo) {
        // PaymentInfo can be used here to create the appropriate builder and return accordingly
        if (paymentMode.equals(PaymentMode.NET_BANKING)) {
            return getNetBankingPaymentManager();
        } else if (paymentMode.equals(PaymentMode.CARD_BASED)) {
            return getCardBasedPaymentManager();
        } else {
            throw new RuntimeException("Invalid Payment Mode.");
        }
    }

    private static CardBasedPaymentManager getCardBasedPaymentManager() {
        return new CardBasedPaymentManagerBuilder().build();
    }

    private static NetBankingPaymentManager getNetBankingPaymentManager() {
        return new NetBankingPaymentManagerBuilder().build();
    }
}
