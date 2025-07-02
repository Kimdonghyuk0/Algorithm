import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Node[][] nodes;

    static class Node {
        int initPoint;
        int min = -1;
        int max = -1;
        int y, x;

        Node(int y, int x, int initPoint) {
            this.initPoint = initPoint;
            this.y = y;
            this.x = x;
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        // 초기값
        for (int i = 0; i < 3; i++) {
            nodes[0][i].min = nodes[0][i].initPoint;
            nodes[0][i].max = nodes[0][i].initPoint;
            q.add(nodes[0][i]);
        }

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int tx = temp.x;
            int ty = temp.y;
            int tmin = temp.min;
            int tmax = temp.max;

            if (ty == N - 1) continue; // 마지막 행 도달 시 종료

            // 현재 위치에서 다음 행으로 이동할 수 있는 x 좌표 목록
            int[] dx;
            if (tx == 0) dx = new int[]{0, 1};
            else if (tx == 1) dx = new int[]{-1, 0, 1};
            else dx = new int[]{-1, 0};

            for (int d : dx) {
                int nx = tx + d;
                if (nx < 0 || nx >= 3) continue; // 열 경계 체크
                int ny = ty + 1;
                Node next = nodes[ny][nx];
                boolean updated = false;

                int minCandidate = next.initPoint + tmin;
                int maxCandidate = next.initPoint + tmax;

                if (next.min == -1 || next.min > minCandidate) {
                    next.min = minCandidate;
                    updated = true;
                }
                if (next.max == -1 || next.max < maxCandidate) {
                    next.max = maxCandidate;
                    updated = true;
                }
                if (updated) q.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N][3];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int k = 0; k < 3; k++) {
                nodes[i][k] = new Node(i, k, Integer.parseInt(input[k]));
            }
        }
        bfs();

        int max = nodes[N - 1][0].max;
        int min = nodes[N - 1][0].min;
        for (int i = 1; i < 3; i++) {
            if (max < nodes[N - 1][i].max) max = nodes[N - 1][i].max;
            if (min > nodes[N - 1][i].min) min = nodes[N - 1][i].min;
        }
        System.out.println(max + " " + min);
    }
}
