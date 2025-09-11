import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int []arrY = new int[n];
        int []arrX = new int[n];
        long sum = 0;
        for(int i = 0; i<n; i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            arrX[i] = x;
            arrY[i] = y;
        }
        for(int i = 0; i < n; i++){
            sum += (long)arrX[i] * arrY[(i+1) % n] - (long)arrX[(i+1) % n] * arrY[i];
        }
        double ans = Math.abs(sum) / 2.0;
        System.out.printf("%.1f\n", ans);

    }
}