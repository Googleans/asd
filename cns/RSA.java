import java.io.IOException;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Random;
 public class RSA {
    private int n = 0;
    private int e = 0;
    private int d = 0;
    public void setKeys(int p, int q) {
        this.n = p * q;
        int phiOfN = (p - 1) * (q - 1);
        List<Integer> listOfE = new ArrayList<>();
        for (int i = 2; i < phiOfN; i++) {
            if(GCD(i, phiOfN) == 1) {
                listOfE.add(i);
            }
        }
        Random random = new Random();
        int randomIndex = random.nextInt(listOfE.size());
        this.e = listOfE.get(randomIndex);
        int i = 1;
        while ( (e * i) % phiOfN != 1) {
            i++;
        }
        this.d = i;
    }
    private int GCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        else {
            return GCD(b, a % b);
        }
    }
    public int encrypt(int M) {
        int C = M % n;
        for (int i = 0; i < e - 1; i++) {
            C = (C * (M % n)) % n;
        }
        return C;
    }
    public int decrypt(int C) {
        int M = C % n;
        for (int i = 0; i < d - 1; i++) {
            M = (M * (C % n)) % n;
        }
        return M;
    }
 public static void main(String[] args) throws IOException {
  RSA rsa = new RSA();
  rsa.setKeys(17,11);
 int input = 88;
 int cipher = rsa.encrypt(input);
 int plain = rsa.decrypt(cipher);
  System.out.println("Input text     : " + input );
  System.out.println("Cipher text    : " + cipher);
  System.out.println("Decrypted text : " + plain);
    }
 }
