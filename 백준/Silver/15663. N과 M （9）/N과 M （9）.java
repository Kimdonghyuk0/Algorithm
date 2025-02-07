import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private int n, m;
    private int[] numbers;
    private Integer[] ans;
    private List<Integer[]> list = new ArrayList<>();
    private boolean[] visited;

    private void dfs(int start, int depth) {
        if (depth == m) {
            list.add(ans.clone());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[depth] = numbers[i];
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }

        }
    }

    public List<Integer[]> solve(int n, int m, int[] numbers) {
        Arrays.sort(numbers);
        ans = new Integer[m];
        visited = new boolean[n];
        this.numbers = numbers;
        this.n = n;
        this.m = m;
        dfs(0, 0);

        // TreeSet을 사용하여 중복 제거와 정렬
        TreeSet<Integer[]> set = new TreeSet<>((a, b) -> {
            for (int i = 0; i < a.length; i++) {
                int cmp = Integer.compare(a[i], b[i]);
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });

        // list에 저장된 모든 배열을 복사하여 TreeSet에 추가
        for (Integer[] arr : list) {
            set.add(Arrays.copyOf(arr, arr.length));
        }

        // TreeSet을 ArrayList로 변환하여 반환
        return new ArrayList<>(set);

        
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
        StringBuilder sb = new StringBuilder();
        for (Integer[] iter : solution.solve(N, M, numbers)) {
            for (int val : iter) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
