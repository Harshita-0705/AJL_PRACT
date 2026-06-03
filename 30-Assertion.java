public class AssertionDemo {

    static int divide(int a, int b) {
        // Assertion to ensure divisor is not zero
        assert b != 0 : "Divisor must not be zero";
        return a / b;
    }

    public static void main(String[] args) {

        int x = 10;
        int y = 0;

        System.out.println("Result: " + divide(x, y));
    }
}
// javac AssertionDemo.java
// java -ea AssertionDemo
// (-ea = enable assertions)