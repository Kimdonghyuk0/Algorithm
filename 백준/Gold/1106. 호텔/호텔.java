import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int[] dp;

        int c, n;
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[][] arr = new int[n][2];
        dp = new int[c+1];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int v,gain;
            v = Integer.parseInt(st.nextToken());
            gain = Integer.parseInt(st.nextToken());
            arr[i][0] = v;
            arr[i][1] = gain;
        }
        Arrays.fill(dp, 1000000);

        for(int i = 1; i<=c; i++){
            int cost = 1000000;
            for(int j =0 ; j< arr.length; j++){
                if(arr[j][1]>=i && arr[j][0]<cost){
                    cost = arr[j][0];
                }
            }
            int minV = 1000000;
            for(int k = 1; k<=i/2;k++ ){
                minV = Math.min(minV,dp[k]+dp[i-k]);
            }

            dp[i] = Math.min(minV,cost);
        }
        System.out.println(dp[c]);
    }
}