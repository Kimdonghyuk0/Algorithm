import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    private int n;
    private int m;
    private int[] ans;
    private int[] arr;
    private boolean[] visited;


    public String solution(int n, int m, int[] arr) {
        this.n = n;
        this.m = m;
        this.arr = arr; //오름차순 정렬된 상
        ans = new int[m];
        visited = new boolean[n];
        StringBuilder sb = new StringBuilder();
        dfs(0, sb);
        return sb.toString();
    }

    public void dfs(int depth, StringBuilder sb) {
        if (depth == m) {
            for (int val : ans) {
                sb.append(val).append(" ");

            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans[depth] = arr[i];
                visited[i] = true;
                dfs(depth + 1, sb);
                visited[i] = false;
            }
        }

    }
}

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Solution sol = new Solution();
        System.out.println(sol.solution(N, M, arr));


    }


}
