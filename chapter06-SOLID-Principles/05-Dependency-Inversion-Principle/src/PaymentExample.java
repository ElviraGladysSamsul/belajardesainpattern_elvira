import java.util.*;

// Payment interface defining operations related to payments
interface PaymentGateway {
    void processPayment(double amount);
    String getPaymentStatus(int transactionId);
}

// Implementation of PaymentGateway for Credit Card payments
class CreditCardPayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of: $" + amount);
    }

    @Override
    public String getPaymentStatus(int transactionId) {
        // Dummy implementation, replace with actual logic
        return "Completed";
    }
}

// Implementation of PaymentGateway for PayPal payments
class PayPalPayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of: $" + amount);
    }

    @Override
    public String getPaymentStatus(int transactionId) {
        // Dummy implementation, replace with actual logic
        return "Pending";
    }
}

// PaymentService using PaymentGateway via constructor injection
class PaymentService {
    private final PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void makePayment(double amount) {
        paymentGateway.processPayment(amount);
    }

    public void checkPaymentStatus(int transactionId) {
        String status = paymentGateway.getPaymentStatus(transactionId);
        System.out.println("Payment status for transaction " + transactionId + ": " + status);
    }
}

// Main class demonstrating the usage of PaymentService
public class PaymentExample {
    public static void main(String[] args) {
        // Using CreditCardPayment
        PaymentGateway creditCardPayment = new CreditCardPayment();
        PaymentService creditCardPaymentService = new PaymentService(creditCardPayment);
        creditCardPaymentService.makePayment(100.0);
        creditCardPaymentService.checkPaymentStatus(1);

        System.out.println();

        // Using PayPalPayment
        PaymentGateway payPalPayment = new PayPalPayment();
        PaymentService payPalPaymentService = new PaymentService(payPalPayment);
        payPalPaymentService.makePayment(200.0);
        payPalPaymentService.checkPaymentStatus(2);
    }
}
