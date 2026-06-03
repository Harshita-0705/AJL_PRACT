// MD5 & SHA 256
import java.security.MessageDigest;

public class HashDemo {

    // Method to generate hash
    public static String generateHash(String input, String algorithm) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = md.digest(input.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    public static void main(String[] args) throws Exception {

        String text = "HelloJava";

        System.out.println("Original Text : " + text);
        System.out.println("MD5 Hash      : " + generateHash(text, "MD5"));
        System.out.println("SHA-256 Hash  : " + generateHash(text, "SHA-256"));
    }
}