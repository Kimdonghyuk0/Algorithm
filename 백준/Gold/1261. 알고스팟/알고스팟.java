import java.io.*;
import java.util.*;

class Node {
    int y, x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        dist = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        bfs01();

        System.out.println(dist[n][m]);
    }

    static void bfs01() {
        Deque<Node> deque = new ArrayDeque<>();
        dist[1][1] = 0;
        deque.addFirst(new Node(1, 1));

        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 1 || ny > n || nx < 1 || nx > m) continue;

                int cost = map[ny][nx];

                if (dist[now.y][now.x] + cost < dist[ny][nx]) {
                    dist[ny][nx] = dist[now.y][now.x] + cost;

                    if (cost == 0) {
                        deque.addFirst(new Node(ny, nx));
                    } else {
                        deque.addLast(new Node(ny, nx));
                    }
                }
            }
        }
    }
}