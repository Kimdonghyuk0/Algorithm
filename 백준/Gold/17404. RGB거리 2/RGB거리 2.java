import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N + 1][3]; // 1-indexed
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // R
            cost[i][1] = Integer.parseInt(st.nextToken()); // G
            cost[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        int ans = 9999999;

        // 첫 집 색을 0(R), 1(G), 2(B)로 각각 고정해서 3번 DP
        for (int first = 0; first < 3; first++) {
            int[][] dp = new int[N + 1][3];

            // 초기화
            for (int c = 0; c < 3; c++) dp[1][c] = 9999999;

            dp[1][first] = cost[1][first];

            // 인접한 집은 같은 색 불가
            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            // 마지막 집은 첫 집 색과 달라야 함
            for (int last = 0; last < 3; last++) {
                if (last == first) continue;
                ans = Math.min(ans, dp[N][last]);
            }
        }

        System.out.println(ans);
    }
}
