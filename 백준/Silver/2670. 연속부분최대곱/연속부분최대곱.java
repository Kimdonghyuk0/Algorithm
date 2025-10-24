import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double sum;
        double[] dp = new double[N];
        for(int i = 0; i<N; i++){
            dp[i] = Double.parseDouble(br.readLine());
        }
        sum = dp[0];
        for(int i = 1; i<N; i++){
            dp[i] = Math.max(dp[i], dp[i-1] * dp[i]);
            if (dp[i] > sum) sum = dp[i];
        }
        System.out.printf("%.3f",sum);
    }
}