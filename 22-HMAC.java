// HMAC (Hash-based Message Authentication Code) ensures data integrity and authenticity using a secret key + hash algorithm.
import javax.crypto.Mac;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class HMACDemo {

    // Generate HMAC
    public static String generateHmac(String message, SecretKey key) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        byte[] hmacBytes = mac.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(hmacBytes);
    }

    public static void main(String[] args) throws Exception {

        // Generate secret key
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
        SecretKey secretKey = keyGen.generateKey();

        String message = "Hello Java Security";

        // Generate HMAC
        String hmac = generateHmac(message, secretKey);
        System.out.println("Message : " + message);
        System.out.println("HMAC    : " + hmac);

        // Verify HMAC
        String verifyHmac = generateHmac(message, secretKey);

        if (hmac.equals(verifyHmac)) {
            System.out.println("HMAC Verified Successfully");
        } else {
            System.out.println("HMAC Verification Failed");
        }
    }
}