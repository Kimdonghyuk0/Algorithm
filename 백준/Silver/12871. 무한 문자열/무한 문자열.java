import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int num = lcm(str2.length(), str1.length());
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < num / str1.length(); i++) {
            s1 += str1;
        }
        for (int i = 0; i < num / str2.length(); i++) {
            s2 += str2;
        }
        if (s1.equals(s2)) System.out.println("1");
        else System.out.println("0");

    }
}
