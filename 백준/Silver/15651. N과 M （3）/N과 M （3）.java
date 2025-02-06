import java.io.*;

class Solution {
    private int n;
    private int m;
    private int[] arr;

    public String solution(int n, int m) {
        this.n = n;
        this.m = m;
        arr = new int[m];
        StringBuilder sb = new StringBuilder();
        dfs(0, sb);
        return sb.toString();
    }

    public void dfs(int depth, StringBuilder sb) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");

            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1, sb);
        }
    }


}

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Solution sol = new Solution();
        System.out.println(sol.solution(N, M));


    }


}
