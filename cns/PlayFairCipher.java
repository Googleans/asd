import java.util.*;
 public class PlayFairCipher {
    private char[][] key;
    public PlayFairCipher(){
        this.key =  new char[5][5];
    }
    public void setKey(String keyMessage){
        String keyString = keyMessage + "ABCDEFGHIKLMNOPQRSTUVWXYZ"; 
        StringBuilder usedChars = new StringBuilder();
        for (char c : keyString.toCharArray()) {
            if (usedChars.indexOf(c + "") == -1) {
                usedChars.append(c);
            }
        }
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                key[i][j] = usedChars.charAt(k++);
            }
        }
    }
    private String processMessage(String message){
        String m = message.toUpperCase().replaceAll("J", "I");
        StringBuilder text = new StringBuilder();
        for(int i = 0; i < m.length(); i++){
            char first = m.charAt(i);
            char second = (i + 1) >= m.length() ? 'X' : m.charAt(i + 1);
            if(first == second)
                text.append(first).append("X");
            else{
                text.append(first).append(second);
                i++;
            }
               
        }
        return text.toString();
    }
    private int[] findIndex(char c){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(key[i][j] == c)
                    return new int[]{i, j};
            }
        }
        return null;
    }
    private String encryptPair(char a, char b, boolean doEncrypt){
        int flag = (doEncrypt) ? 1 : -1;
        int[] p1 = findIndex(a);
        int[] p2 = findIndex(b);
        if (p1[0] == p2[0]) { 
            return "" + key[p1[0]][(p1[1] + flag + 5) % 5] + key[p2[0]][(p2[1] + flag + 
5) % 5];
        } 
        else if (p1[1] == p2[1]) { 
            return "" + key[(p1[0] + flag + 5) % 5][p1[1]] + key[(p2[0] + flag + 5) % 
5][p2[1]];
        } 
        else {  
            return "" + key[p1[0]][p2[1]] + key[p2[0]][p1[1]];
        }
    }
    public String encrypt(String m){
        String message = processMessage(m);
        StringBuilder cipherText = new StringBuilder();
        for(int i = 0; i < message.length(); i += 2){
            cipherText.append(encryptPair(message.charAt(i),message.charAt(i + 
1),true));
        }
        return cipherText.toString();
    }
    public String decrypt(String message){
        StringBuilder plainText = new StringBuilder();
        for(int i = 0; i < message.length(); i += 2){
            plainText.append(encryptPair(message.charAt(i),message.charAt(i + 
1),false));
        }
        
        return plainText.toString().replaceAll("X", "").toLowerCase();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlayFairCipher pf = new PlayFairCipher();
        System.out.println("Enter the  key(String) :");
        String keyString = sc.next().toUpperCase();
        sc.nextLine();
        System.out.println("Enter the Message : ");
        String message = sc.nextLine();
        System.out.println("The original message : " + message);
        pf.setKey(keyString);
        String cipherText = pf.encrypt(message);
        System.out.println("The Cipher text : " + cipherText);
        System.out.println("The Plain text : " + pf.decrypt(cipherText));
        sc.close();
    }
 }
