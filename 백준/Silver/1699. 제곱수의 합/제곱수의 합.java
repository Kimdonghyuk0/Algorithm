import java.io.*;
        import java.util.*;

class Main {
    static final long MOD = 1_000_000_009L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i<100001; i++){
            //제일 가까운 제곱근 찾기
            for(int j = 1; j<=(int)Math.sqrt(i); j++ ){
                dp[i] = Math.min(dp[i-j*j]+1,dp[i]);
            }

        }
        System.out.println(dp[N]);
    }
}
