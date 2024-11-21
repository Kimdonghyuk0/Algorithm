import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ans = Integer.parseInt(st.nextToken()) - 1;
            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                String temp = br.readLine();
            }
            System.out.println(ans);
        }
        br.close();
    }
}

