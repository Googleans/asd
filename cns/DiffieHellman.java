import java.math.BigInteger;
import java.security.SecureRandom; 
import java.util.Scanner; 
 
public class DiffieHellman { 
 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
         
        // Step 1: Publicly known prime modulus and base 
        System.out.print("Enter a prime number (p): "); 
        BigInteger p = scanner.nextBigInteger(); 
         
        System.out.print("Enter a primitive root modulo p (g): "); 
        BigInteger g = scanner.nextBigInteger(); 
         
        // Step 2: Private keys for Sender and Receiver 
        SecureRandom random = new SecureRandom(); 
         
        System.out.print("Enter Sender's private key: "); 
        BigInteger senderPrivateKey = scanner.nextBigInteger(); // Sender's private key 
         
        System.out.print("Enter Receiver's private key: "); 
        BigInteger receiverPrivateKey = scanner.nextBigInteger(); // Receiver's private key 
 
        // Step 3: Compute public keys 
        BigInteger senderPublicKey = g.modPow(senderPrivateKey, p); // Sender's public key 
        BigInteger receiverPublicKey = g.modPow(receiverPrivateKey, p); // Receiver's public key 
         
        System.out.println("\nSender's Public Key: " + senderPublicKey); 
        System.out.println("Receiver's Public Key: " + receiverPublicKey); 
         
         
// Step 4: Compute shared secret key 
        BigInteger sharedKeySender = receiverPublicKey.modPow(senderPrivateKey, p); // Shared secret key for Sender 
        BigInteger sharedKeyReceiver = senderPublicKey.modPow(receiverPrivateKey, p); // Shared secret key for Receiver 
         
        System.out.println("\nShared Secret Key Computed by Sender: " + sharedKeySender); 
        System.out.println("Shared Secret Key Computed by Receiver: " + sharedKeyReceiver); 
         
        // Check if keys match 
        if (sharedKeySender.equals(sharedKeyReceiver)) { 
            System.out.println("The Diffie-Hellman Key Exchange was successful!"); 
        } else { 
            System.out.println("Key exchange failed. The keys do not match."); 
        } 
         
        scanner.close(); 
    } 
} 
 
 
 
 
 
 
