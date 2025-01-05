import java.io.*;
import java.util.*;


public class Main {
    public static int[] member;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public
    static void bfs(int s) {
        Arrays.fill(visited, false);

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        int end = s;
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int size = q.size(); // 현재 단계에 있는 노드 수
            count++; // 단계 증가
            for (int k = 0; k < size; k++) {
                int x = q.poll();
                for (int i = 0; i < graph.get(x).size(); i++) {
                    int next = graph.get(x).get(i);
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                        member[s] += count;
                    }

                }
            }


        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        member = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for (int i = 1; i < N + 1; i++) {
            bfs(i);
        }
        int ans = 1;
        int min = member[1];
        for (int i = 2; i < N + 1; i++) {
            if (min > member[i]) {
                min = member[i];
                ans = i;
            }
        }
        System.out.println(ans);
    }


}
