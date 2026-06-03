// Custom Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class ATM {

    private double balance = 5000;

    // Method with throws
    void withdraw(double amount) throws InsufficientBalanceException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

public class AdvancedExceptionDemo {

    public static void main(String[] args) {

        ATM atm = new ATM();

        try {
            atm.withdraw(7000);   // change value to test cases
        }
        catch (InsufficientBalanceException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
        finally {
            System.out.println("Transaction completed. Thank you for using ATM.");
        }
    }
}