import java.io.*;

class Main {
    static final int MOD = 100000; // 마지막 5자리만 필요

    static long powMod(long a, long e) {
        long r = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long ans = 1;
        long cnt2 = 0, cnt5 = 0;

        for (int i = 2; i <= N; i++) {
            int x = i;

            while ((x & 1) == 0) { // x % 2 == 0
                x >>= 1;
                cnt2++;
            }
            while (x % 5 == 0) {
                x /= 5;
                cnt5++;
            }

            ans = (ans * (x % MOD)) % MOD;
        }

        long diff = cnt2 - cnt5;          // 남는 2의 개수
        ans = (ans * powMod(2, diff)) % MOD;

        System.out.printf("%05d\n", ans);
    }
}
