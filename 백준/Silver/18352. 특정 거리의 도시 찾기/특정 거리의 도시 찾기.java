import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    static Queue<Integer> q = new LinkedList<>();
    static boolean visited[];
    static int dis[];
    static ArrayList<Integer>[] graph;

    static void bfs(int start) {
        int currentLev = 0;
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int temp = q.poll();
                for (int next : graph[temp]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                    if (dis[next] == 0) {
                        dis[next] = currentLev + 1;
                    }

                }
            }
            currentLev++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, K, X;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        dis = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            graph[t1].add(t2);

        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        bfs(X);
        for (int i = 1; i < N + 1; i++) {
            if (dis[i] == K) arrayList.add(i);
        }
        if (arrayList.size() == 0) {
            System.out.println("-1");
            return;
        }
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}

