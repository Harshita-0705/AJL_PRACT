interface PaymentService {
    void pay();
}

class BasicPaymentService implements PaymentService {
    public void pay() {
        System.out.println("Payment processed");
    }
}

class LoggingDecorator implements PaymentService {

    private PaymentService service;

    LoggingDecorator(PaymentService service) {
        this.service = service;
    }

    public void pay() {
        System.out.println("Logging request...");
        service.pay();
    }
}

public class DecoratorDemo  {
    public static void main(String[] args) {

        PaymentService service =
            new LoggingDecorator(new BasicPaymentService());

        service.pay();
    }
}