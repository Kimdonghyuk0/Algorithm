import java.io.*;
        import java.util.*;

class Main {
    static final long MOD = 1_000_000_009L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[100005][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;
        for(int i = 1; i<=100000; i++){
            dp[i + 1][1] = (dp[i][2] + dp[i][3]) % MOD;
            dp[i + 2][2] = (dp[i][1] + dp[i][3]) % MOD;
            dp[i + 3][3] = (dp[i][1] + dp[i][2]) % MOD;
        }

        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            System.out.println((dp[n][1]+dp[n][2]+dp[n][3])%1000000009);
        }
    }
}
