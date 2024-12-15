  
import java.util.Scanner; 
public class Hill { 
 static void encrypt(int[][] keyMatrix, int[] messageVector, int[] cipherMatrix, int size) { 
        for (int i = 0; i < size; i++) { 
            cipherMatrix[i] = 0; 
            for (int j = 0; j < size; j++) { 
                cipherMatrix[i] += keyMatrix[i][j] * messageVector[j]; 
            } 
            cipherMatrix[i] = cipherMatrix[i] % 26; 
        } 
    } 
 static int[][] getKeyMatrix(Scanner sc, int size) { 
        int[][] keyMatrix = new int[size][size]; 
        System.out.println("Enter the key matrix (" + size + "x" + size + "):"); 
        for (int i = 0; i < size; i++) { 
            for (int j = 0; j < size; j++) { 
                keyMatrix[i][j] = sc.nextInt(); 
            } 
        } 
        return keyMatrix; 
    } 
 static int[] getMessageVector(String message, int start, int size) { 
        int[] messageVector = new int[size]; 
        for (int i = 0; i < size; i++) { 
            messageVector[i] = message.charAt(start + i) - 'A';  
        } 
        return messageVector; 
    }    static String getCipherText(int[] cipherMatrix, int size) { 
        StringBuilder cipherText = new StringBuilder(); 
        for (int i = 0; i < size; i++) { 
            cipherText.append((char) (cipherMatrix[i] + 'A'));         } 
        return cipherText.toString(); 
    } 
 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
System.out.println("Enter the size of the key matrix (2x2 or 3x3):"); 
 
int size = sc.nextInt(); 
 
        // Get the key matrix 
        int[][] keyMatrix = getKeyMatrix(sc, size); 
 
        // Get the plaintext 
        System.out.println("Enter the plaintext :"); 
        String plaintext = sc.next().toUpperCase(); 
 
         
        int length = plaintext.length(); 
        if (length % size != 0) { 
            int padding = size - (length % size); 
            for (int i = 0; i < padding; i++) { 
                plaintext += 'X';  
            } 
        } 
 
                
    StringBuilder finalCipherText = new StringBuilder(); 
        for (int i = 0; i < plaintext.length(); i += size) { 
            int[] messageVector = getMessageVector(plaintext, i, size); 
            int[] cipherMatrix = new int[size]; 
            encrypt(keyMatrix, messageVector, cipherMatrix, size); 
            finalCipherText.append(getCipherText(cipherMatrix, size)); 
        } 
 
                System.out.println("Encrypted Ciphertext: " + finalCipherText.toString()); 
 
        sc.close(); 
    } 
} 
 
