import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph = new ArrayList[101];
    static boolean[] visited = new boolean[101];
    static int[] dist = new int[101];
    static Map<Integer,Integer> map = new HashMap<>();
    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        dist[1] = 0;
        while(!q.isEmpty()){
            int now = q.poll();

            for(int i = 1; i<=6; i++){
                int next = now+i;
                if(next > 100) continue;
               
                if(!graph[next].isEmpty()){
                    next = graph[next].get(0);
                }
                if(visited[next]) continue;
                visited[next] = true;
                dist[next] = dist[now]+1;
                q.add(next);

            }
        }
    }

    public static void main(String[] args) throws Exception {
        Arrays.fill(dist,Integer.MAX_VALUE);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //다음 정점이 사다리나 뱀이라면 카운트 하면 안된다.
        //그래프 초기화
        for(int i = 0; i<101; i++){
            graph[i] = new ArrayList<>();
        }

        // 그래프는 각 전점 +1~+6 까지 연결되어있다 단 1-100
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //사다리
        int M = Integer.parseInt(st.nextToken()); //뱀
        //사다리 그래프
        for(int i =0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            map.put(s,e);
        }
        //뱀 그래프
        for(int i =0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            map.put(s,e);
        }

        // bfs로 최소경로 구하기
        bfs(1);
        System.out.println(dist[100]);

    }
}