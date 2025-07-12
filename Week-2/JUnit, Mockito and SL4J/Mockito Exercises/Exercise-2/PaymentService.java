package com.example.mock;

public class PaymentService {
    private final Logger log;

    public PaymentService(Logger log) {
        this.log = log;
    }

    public void processPayment(String userId, double amount) {
        // Simulate payment logic (skipped)
        String logMessage = "Payment of $" + amount + " received from user: " + userId;
        log.log(logMessage);
    }
}
