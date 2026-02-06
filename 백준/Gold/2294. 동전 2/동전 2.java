import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i = 0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k+1];
        Arrays.fill(dp,Integer.MAX_VALUE-10);
        dp[0] = 0;
        for(int c:coins){
            for(int i = c; i<=k; i++){
                if(i-c>=0){
                    dp[i] = Math.min(dp[i],dp[i-c]+1);
                }
            }
        }
        if(dp[k]==Integer.MAX_VALUE-10)System.out.println("-1");
        else System.out.println(dp[k]);
    }
}