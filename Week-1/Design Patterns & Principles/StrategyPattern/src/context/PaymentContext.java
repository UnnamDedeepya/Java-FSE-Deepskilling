package context;

import strategy.PaymentStrategy;

public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        if (strategy != null) {
            strategy.pay(amount);
        } else {
            System.out.println("No payment strategy selected.");
        }
    }
}
