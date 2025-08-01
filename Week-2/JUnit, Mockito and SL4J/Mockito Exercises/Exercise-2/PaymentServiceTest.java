package com.example.mock;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {

    @Test
    public void testProcessPayment_logsCorrectly() {
        // Step 1: Create a mock logger
        Logger mockLog = mock(Logger.class);

        // Step 2: Inject it into PaymentService
        PaymentService service = new PaymentService(mockLog);

        // Step 3: Call method
        service.processPayment("user123", 99.99);

        // Step 4: Verify correct log message
        verify(mockLog).log("Payment of $99.99 received from user: user123");
    }
}
