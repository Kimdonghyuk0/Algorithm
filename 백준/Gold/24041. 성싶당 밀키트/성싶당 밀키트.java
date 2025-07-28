import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long G = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] speed = new long[N], limit = new long[N];
        boolean[] unimportant = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            speed[i]       = Long.parseLong(st.nextToken());
            limit[i]       = Long.parseLong(st.nextToken());
            unimportant[i] = st.nextToken().equals("1");
        }

        long left = 1L, right = 2_000_000_000L, answer = 0L;
        // buffer for unimportant‐ingredient bacteria counts
        long[] buf = new long[N];

        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (canEat(mid, N, G, K, speed, limit, unimportant, buf)) {
                answer = mid;
                left   = mid + 1;
            } else {
                right  = mid - 1;
            }
        }

        System.out.println(answer);
    }

    // x일까지 먹을 수 있는지 판단
    static boolean canEat(long x, int N, long G, int K,
                          long[] speed, long[] limit, boolean[] unimp,
                          long[] buf) {
        long cap    = G + 1; // 클램핑 상한
        long sumAll = 0L;
        int m       = 0;

        // 1) 모든 재료의 세균 수 구하고 총합, unimportant만 buf에 모으기
        for (int i = 0; i < N; i++) {
            long days = x - limit[i] > 1 ? x - limit[i] : 1;
            // 곱셈 오버플로우 방지 + G+1 초과 클램핑
            long b = speed[i] > cap / days ? cap : speed[i] * days;
            sumAll += b;
            if (unimp[i]) {
                buf[m++] = b;
            }
        }
        if (sumAll <= G) return true;

        // 2) 중요하지 않은 재료의 세균 수만 부분 정렬 (오름차순)
        Arrays.sort(buf, 0, m);
        // 3) 가장 큰 것부터 K개 빼 주기
        for (int t = 0; t < K && t < m; t++) {
            sumAll -= buf[m - 1 - t];
            if (sumAll <= G) return true;
        }
        return false;
    }
}
