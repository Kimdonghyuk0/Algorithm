import java.io.*;
import java.nio.Buffer;
import java.util.*;

class Solve {
    private static int[] ans;
    private static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void solve(int n, int m) {
        ans = new int[m];
        visited = new boolean[n + 1];
        dfs(n, m, 0);

    }

    private static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int val : ans) {
                sb.append(val).append(' ');
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i + 1]) {
                visited[i + 1] = true;
                ans[depth] = i + 1;
                dfs(n, m, depth + 1);
                visited[i + 1] = false;
            }
        }

    }
}

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Solve.solve(N, M);
        System.out.println(Solve.sb);

    }


}
