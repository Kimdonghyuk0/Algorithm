import java.io.*;
        import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //전형적인 dp문제이다.
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i], dp[i-1]);
            if(day+i-1>N)continue;
            dp[i+day-1] = Math.max(dp[i-1]+cost,dp[i+day-1]);
            

        }
        int max = 0;
        for(int n:dp)if(n>max)max=n;
        System.out.println(max);
    }
}
