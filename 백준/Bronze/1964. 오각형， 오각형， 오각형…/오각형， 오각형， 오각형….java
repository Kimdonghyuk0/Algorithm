import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 5;
        if (n == 1) {
            System.out.println(sum);
            
        }
        for (int i = 1; i < n; i++) {
            sum += 4 + 3 * i;
        }
       if(n>1) System.out.println(sum % 45678);
    }
}
