package adapter;

import adaptee.StripeGateway;
import target.PaymentProcessor;

public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter() {
        this.stripe = new StripeGateway();
    }

    @Override
    public void processPayment(double amount) {
        stripe.execute(amount);  // adapting method
    }
}