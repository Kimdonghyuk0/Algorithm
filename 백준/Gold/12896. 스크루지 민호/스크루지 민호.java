import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int maxDis = 0;
    static int[] dist;
    static int bfs(int start){
        Arrays.fill(visit,false);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visit[start] = true;
        int maxD = 0;
        int nodeNum = -1;
        dist[start] = 0;
        while(!q.isEmpty()){

            int now = q.poll();
            visit[now] = true;
            for(int next:graph[now]){
                if(visit[next])continue;
                q.add(next);
                dist[next] = dist[now] + 1;
                if(dist[next]>maxD){
                    nodeNum=  next;
                    maxD = dist[next];
                }

            }
        }
        maxDis = dist[nodeNum];
        return nodeNum;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 가장 먼 노드간의 거리를 2로 나눈다 (홀수면 반올림)
        //양방향 그래프
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        dist = new int[N+1];
        visit = new boolean[N+1];
        for(int i = 0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 1; i<N; i++){
            int s,e;
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            graph[e].add(s);
            graph[s].add(e);
        }

        int nodeNum = bfs(1); //1번노드에서 먼 노드
        bfs(nodeNum); // 여기서 정점 간 거리가 세팅됨
        if(maxDis%2==0)System.out.println(maxDis/2);
        else System.out.println(maxDis/2+1);

    }
}
