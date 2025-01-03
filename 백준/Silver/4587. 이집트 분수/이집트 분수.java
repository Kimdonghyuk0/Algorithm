import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

import static java.lang.Math.ceil;

public class Main {

    // 유클리드 호제법으로 최대공약수를 구하는 함수
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static Vector<Long> solve(long M1, long N1) {
        Vector<Long> ans = new Vector<>(); // N이 분모, M이 분자
        long N2 = 2;
        long N3, M2;

        while (true) {

            boolean flag = false;
            if (M1 * N2 == N1) {
                break;
            }

            while (true) {
                if (M1 * N2 == N1) {
                    ans.add(N2);
                    break;
                }
                if (M1 * N2 > N1 || flag) {
                    // 빼기 로직
                    if (N2 == N1) {
                        for (int i = 0; i < M1; i++) {
                            ans.add(N2);
                        }
                        M1 = 1;
                        break;
                    }
                    N3 = N1 * N2;
                    M2 = M1 * N2 - N1;

                    // 약분
                    long g = gcd(M2, N3);
                    M2 /= g;
                    N3 /= g;
                    N2++;

                    if (N3 < 1000000) {
                        ans.add(N2 - 1);
                        M1 = M2;
                        N1 = N3;
                        break;
                    }
                    flag = true;
                } else {
                    N2 = (long) ceil((double) N1 / (double) M1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            long M1, N1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M1 = Long.parseLong(st.nextToken());
            N1 = Long.parseLong(st.nextToken());
            if (N1 == 0 && M1 == 0) break;

            Vector<Long> ans = solve(M1, N1);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
