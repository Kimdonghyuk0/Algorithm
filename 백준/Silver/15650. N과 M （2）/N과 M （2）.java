import java.io.*;
import java.nio.Buffer;
import java.util.*;

class Solution {
    private int n;
    private int m;
    private StringBuilder sb = new StringBuilder();
    private int arr[];

    public void dfs(int depth, int start) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    public void solution(int n, int m) {
        this.n = n;
        this.m = m;
        arr = new int[m];
        dfs(0, 1);
    }

    public StringBuilder getSb() {
        return sb;
    }
}

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Solution sol = new Solution();
        sol.solution(N, M);
        System.out.println(sol.getSb());

    }


}
