import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static boolean[] visit;
    static ArrayList<Integer>[] graph;
    static Queue<Integer> q = new LinkedList<>();

    private static void bfs(int start) {
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int nextV : graph[temp]) {
                if (!visit[nextV]) {
                    q.add(nextV);
                    visit[nextV] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        int count = 0;
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]); //정점 개수
        M = Integer.parseInt(str[1]);  //간선 개수
        visit = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                count++;
                bfs(i);
            }
        }
        System.out.println(count);

    }
}

