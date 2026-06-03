import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class DigitalSignatureDemo {

    public static void main(String[] args) throws Exception {

        // Generate RSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();

        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        String message = "Hello Java Digital Signature";

        // Create Digital Signature
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes());
        byte[] signatureBytes = sign.sign();
        String digitalSignature = Base64.getEncoder().encodeToString(signatureBytes);

        System.out.println("Message   : " + message);
        System.out.println("Signature : " + digitalSignature);

        // Verify Digital Signature
        Signature verify = Signature.getInstance("SHA256withRSA");
        verify.initVerify(publicKey);
        verify.update(message.getBytes());
        boolean isVerified = verify.verify(Base64.getDecoder().decode(digitalSignature));

        System.out.println("Signature Verified: " + isVerified);
    }
}