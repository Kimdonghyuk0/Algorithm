import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];

            for(int i = 0; i<N; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int target = Integer.parseInt(br.readLine());
            int[]dp  = new int[target+1]; // 금액은 만원까지

            dp[0] = 1;

            for(int c: coins){
                for(int i = c; i<=target; i++){
                    if((i-c)>=0)dp[i]+=dp[i-c];
                }


            }
            System.out.println(dp[target]);
        }

    }
}