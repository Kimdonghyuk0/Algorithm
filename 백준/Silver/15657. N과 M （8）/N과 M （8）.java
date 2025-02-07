import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private int n, m;
    private int[] numbers;
    private int[] ans;
    StringBuilder sb = new StringBuilder();

    private void dfs(int start, int depth) {
        if (depth == m) {
            for (int val : ans) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            ans[depth] = numbers[i];
            dfs(i, depth + 1);
        }
    }

    public String solve(int n, int m, int[] numbers) {
        Arrays.sort(numbers);
        ans = new int[m];
        this.numbers = numbers;
        this.n = n;
        this.m = m;
        dfs(0, 0);

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;
        int[] numbers;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            numbers[i] = n;
        }
        Solution solution = new Solution();
        System.out.println(solution.solve(N, M, numbers));

    }
}
