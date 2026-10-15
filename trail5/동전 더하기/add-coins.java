import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin);

        int ans = 0;
        int j = N - 1;

        while (target > 0) {
            if (target >= coin[j]) {
                target -= coin[j];
                ans++;
            } else {
                j--;
            }
        }

        System.out.println(ans);
    }
}