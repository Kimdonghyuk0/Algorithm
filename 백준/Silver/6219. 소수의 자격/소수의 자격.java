import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int D = Integer.parseInt(str[2]);
        int count = 0;
        boolean check[] = new boolean[4000001]; //기본값 false
        check[1] = true;
        for (int i = 2; i < Math.sqrt(4000000); i++) {
            int n = i;
            for (int j = 2; j <= 4000000; j++) {
                if (n * j > 4000000) break;
                check[n * j] = true;
            }
        }
        for (int i = A; i <= B; i++) {
            if (!check[i] && Integer.toString(i).contains(Integer.toString(D))) count++;
        }
        System.out.println(count);
    }
}

