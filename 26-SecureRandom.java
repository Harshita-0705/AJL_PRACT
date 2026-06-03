import java.security.SecureRandom;

public class SecureRandomDemo {

    public static void main(String[] args) {

        SecureRandom secureRandom = new SecureRandom();

        // Generate random integer (0–99)
        int randomInt = secureRandom.nextInt(100);

        // Generate random long
        long randomLong = secureRandom.nextLong();

        // Generate random bytes
        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);

        System.out.println("Secure Random Integer : " + randomInt);
        System.out.println("Secure Random Long    : " + randomLong);

        System.out.print("Secure Random Bytes   : ");
        for (byte b : randomBytes) {
            System.out.printf("%02x", b);
        }
    }
}