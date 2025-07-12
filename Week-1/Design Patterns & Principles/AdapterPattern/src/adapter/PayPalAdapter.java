package adapter;

import adaptee.PayPalGateway;
import target.PaymentProcessor;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter() {
        this.paypal = new PayPalGateway();
    }

    @Override
    public void processPayment(double amount) {
        paypal.makePayment(amount);  // adapting method
    }
}