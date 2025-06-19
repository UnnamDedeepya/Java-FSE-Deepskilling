package adaptee;

public class StripeGateway {
    public void execute(double amountInRupees) {
        System.out.println("Payment of ₹" + amountInRupees + " made via Stripe.");
    }
}