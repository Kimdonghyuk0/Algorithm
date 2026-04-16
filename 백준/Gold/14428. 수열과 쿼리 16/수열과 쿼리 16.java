import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] tree;

    static int better(int idx1, int idx2) {
        if (idx1 == -1) return idx2;
        if (idx2 == -1) return idx1;

        if (arr[idx1] < arr[idx2]) return idx1;
        if (arr[idx1] > arr[idx2]) return idx2;
        return Math.min(idx1, idx2);
    }

    static int build(int node, int start, int end) {
        if (start == end) {
            return tree[node] = start;
        }

        int mid = (start + end) / 2;
        int left = build(node * 2, start, mid);
        int right = build(node * 2 + 1, mid + 1, end);

        return tree[node] = better(left, right);
    }

    static int update(int node, int start, int end, int idx) {
        if (idx < start || idx > end) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = start;
        }

        int mid = (start + end) / 2;
        int left = update(node * 2, start, mid, idx);
        int right = update(node * 2 + 1, mid + 1, end, idx);

        return tree[node] = better(left, right);
    }

    static int query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return -1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int lRes = query(node * 2, start, mid, left, right);
        int rRes = query(node * 2 + 1, mid + 1, end, left, right);

        return better(lRes, rRes);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[4 * N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        build(1, 1, N);

        M = Integer.parseInt(br.readLine());
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 1) {
                arr[a] = b;
                update(1, 1, N, a);
            } else {
                sb.append(query(1, 1, N, a, b)).append('\n');
            }
        }

        System.out.print(sb);
    }
}