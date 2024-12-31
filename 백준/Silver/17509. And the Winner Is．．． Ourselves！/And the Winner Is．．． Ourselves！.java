import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        int T = 0;
        int ans = 0;
        int arr[][] = new int[11][2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);

            } else return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < 11; i++) {
            T += arr[i][0];
            ans += T + 20 * arr[i][1];
        }
        System.out.println(ans);
    }
}