import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        String str[] = br.readLine().split(" ");
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);

        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                sum += Math.abs(arr[i] - arr[k]);
            }
        }
        System.out.println(sum);

    }
}
