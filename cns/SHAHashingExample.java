 
import java.security.MessageDigest; 
 
public class SHAHashingExample { 
    public static void main(String[] args) throws Exception { 
        // Input password 
        String password = "123456"; 
 
        // Create MessageDigest instance for SHA-256 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
 
        // Add password bytes to digest 
        md.update(password.getBytes()); 
 
        // Get the hash's bytes 
        byte[] byteData = md.digest(); 
 
        // Convert the byte to hex format method 1 
        StringBuffer sb = new StringBuffer(); 
        for (int i = 0; i < byteData.length; i++) { 
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)); 
        } 
        System.out.println("Hex format (Method 1): " + sb.toString()); 
 
        // Convert the byte to hex format method 2 
        StringBuffer hexString = new StringBuffer(); 
        for (int i = 0; i < byteData.length; i++) {  
             String hex = Integer.toHexString(0xff & byteData[i]); 
            if (hex.length() == 1) hexString.append('0'); 
            hexString.append(hex); 
 } 
        System.out.println("Hex format (Method 2): " + hexString.toString()); 
    } 
} 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
