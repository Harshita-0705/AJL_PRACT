import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSAKeyPairDemo {

    public static void main(String[] args) throws Exception {

        // Create RSA Key Pair Generator
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);

        // Generate Key Pair
        KeyPair keyPair = keyGen.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Print keys
        System.out.println("Public Key:");
        System.out.println(Base64.getEncoder().encodeToString(publicKey.getEncoded()));

        System.out.println("\nPrivate Key:");
        System.out.println(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
    }
}