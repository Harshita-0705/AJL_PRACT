import javax.crypto.Mac;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class MACDemo {

    // Generate MAC
    public static String generateMAC(String message, SecretKey key) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        byte[] macBytes = mac.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(macBytes);
    }

    public static void main(String[] args) throws Exception {

        // Generate secret key
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
        SecretKey secretKey = keyGen.generateKey();

        String message = "Hello Java MAC";

        // Generate MAC
        String macValue = generateMAC(message, secretKey);
        System.out.println("Message : " + message);
        System.out.println("MAC     : " + macValue);

        // Verify MAC
        String verifyMac = generateMAC(message, secretKey);

        if (macValue.equals(verifyMac)) {
            System.out.println("MAC Verified Successfully");
        } else {
            System.out.println("MAC Verification Failed");
        }
    }
}