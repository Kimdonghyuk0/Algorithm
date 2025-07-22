import java.io.*;
import java.util.*;

public class Main {
    static int N,K,M;
    static ArrayList<Integer>[] graph;
    static int[] dist;
    static boolean[] visited;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        dist[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    if(next<=N)dist[next] = dist[now] + 1;
                    else dist[next] = dist[now];
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+M+1];
        visited = new boolean[N+M+1];
        dist = new int[N + M+ 1];

        for (int i = 0; i < graph.length ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = N+1; i <= N+M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<K; j++){
                int n = Integer.parseInt(st.nextToken());
                graph[i].add(n);
                graph[n].add(i);
            }

        }

        bfs(1);
        if(dist[N]==0)System.out.println("-1");
        else System.out.println(dist[N]);


    }
}
