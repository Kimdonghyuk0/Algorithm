import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine().trim());

        for (int y = X + 1; y <= 9999; y++) {
            int a = y / 100;  
            int b = y % 100;  
            int s = a + b;
            if (s * s == y) {
                System.out.println(y);
                return;
            }
        }
        System.out.println(-1);
    }
}
