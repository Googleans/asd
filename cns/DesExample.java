import java.util.Base64;
import java.util.Scanner; 
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey; 
 
public class DesExample { 
 
    // Method to generate a secret key for DES 
    public static SecretKey generateKey() throws Exception { 
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES"); 
        keyGenerator.init(56); // DES uses a key size of 56 bits 
        return keyGenerator.generateKey(); 
    } 
 
    // Method to encrypt a string using DES 
    public static String encrypt(String data, SecretKey key) throws Exception { 
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding"); // DES with ECB mode and PKCS5 
        cipher.init(Cipher.ENCRYPT_MODE, key); 
        byte[] encryptedData = cipher.doFinal(data.getBytes()); 
        return Base64.getEncoder().encodeToString(encryptedData); // Encoding to Base64 for readability 
    } 
 
    // Method to decrypt a string using DES 
    public static String decrypt(String encryptedData, SecretKey key) throws Exception { 
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding"); 
        cipher.init(Cipher.DECRYPT_MODE, key);  
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData)); 
        return new String(decryptedData); 
    } 
 
    public static void main(String[] args) { 
        try { 
            // Generate a secret key for DES encryption 
            SecretKey secretKey = generateKey(); 
             
            Scanner sc = new Scanner(System.in); 
 
            // Get the plaintext from the user 
            System.out.println("Enter the text to encrypt:"); 
            String plaintext = sc.nextLine(); 
 
            // Encrypt the plaintext 
            String encryptedText = encrypt(plaintext, secretKey); 
            System.out.println("Encrypted Text: " + encryptedText); 
 
            // Decrypt the encrypted text 
            String decryptedText = decrypt(encryptedText, secretKey); 
            System.out.println("Decrypted Text: " + decryptedText); 
 
            sc.close(); 
 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 
 
 
 
 
 
 
 