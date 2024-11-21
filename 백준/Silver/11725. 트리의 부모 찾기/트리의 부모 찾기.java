import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    private static Queue<Integer> q = new LinkedList<>();
    private static ArrayList<Integer>[] graph;
    private static int parent[];
    private static boolean visited[];

    private static void bfs(int start) {
        q.add(start);
        while (!q.isEmpty()) {
            int temp = q.poll();
            visited[temp] = true;
            for (int nextV : graph[temp]) {
                if (!visited[nextV]) {
                    q.add(nextV);
                    parent[nextV] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        bfs(1);
        for (int i = 2; i < n + 1; i++) {
            System.out.println(parent[i]);
        }
    }
}

