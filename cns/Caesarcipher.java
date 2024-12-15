import java.util.*;
 public class Caesarcipher {
 private int key;
 public Caesarcipher(){}
 public Caesarcipher(int key){
 this.key = key;
    }
 public void setKey(int key){
 this.key = key;
    }
 public  String encrypt(String message)
    {
  StringBuilder result = new StringBuilder("");
 for(char ch : message.toCharArray()){
 char start = (ch >= 'a') ? 'a' : 'A';
      result.append((ch == ' ') ? ' ' : (char)((((ch - start) + key) % 26) + 
start));
  }
 return result.toString();
    }
 public String decrypt(String message)
    {
  StringBuilder result = new StringBuilder("");
 for(char ch : message.toCharArray()){
 char start = (ch >= 'a') ? 'a' : 'A';
      result.append((ch == ' ') ? ' ' : (char)(((ch - start) - key + 26) % 26 + 
start) );
  }
 return result.toString();
    }
 public static void main(String[] args) {
  Caesarcipher cc = new Caesarcipher();
  cc.setKey(3);
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter the message:");
  String message = sc.nextLine();
  String cipherText = cc.encrypt(message);
  String originalText = cc.decrypt(cipherText);
  System.out.println("Message : " + message);
  System.out.println("Cipher text : " + cipherText);
  System.out.println("Original text : " + originalText);
  sc.close();
    }
 }