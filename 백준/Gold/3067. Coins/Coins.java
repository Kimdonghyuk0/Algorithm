import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                int[] coins = new int[N];
                // 동전 종류 입력 받음
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    coins[j] = Integer.parseInt(st.nextToken());
                }

                int target = Integer.parseInt(br.readLine());

                int[] dp = new int[target + 1];
                dp[0] = 1;
                for(int coin:coins){
                    for(int j = coin; j<target+1; j++){
                        dp[j] += dp[j-coin];
                    }
                }
                System.out.println(dp[target]);
            }
        }

}
