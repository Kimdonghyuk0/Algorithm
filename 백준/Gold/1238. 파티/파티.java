import java.io.*;
import java.util.*;

// N,M,X 정점 수 , 간선 수, 만나는 장소 다익스트라 , 단방향
// 출발 도착 가중치
//첫 번째 줄에 N명의 학생들 중 오고 가는데 가장 오래 걸리는 학생의 소요시간을 출력한다.
// X에서 출발을 하고 각 마을에 도착하는 최장시간 * 2 가 정답
class Node{
    int to,w;
    Node(int to, int w){
        this.to = to;
        this.w = w;
    }

}
public class Main {
    static int N,M,X;
    static int[] dist;
    static int[] finalD;
    static List<Node>[] graph;
    static List<Node>[] reverseGraph; // 역방향
    static int INF = 9000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        finalD = new int[N+1];
        graph = new ArrayList[N+1];
        reverseGraph = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start,end,w;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end,w));
            reverseGraph[end].add(new Node(start,w));
        }
        // X에서 학생
        dstra(X,graph);
        int[] back = dist.clone();
        //각 학생 별로 X가는 경로
        dstra(X,reverseGraph);
        int[] go = dist.clone();
        //dist에서    큰값찾기
        int max = 0;
        for(int i = 1; i<=N; i++){
            if(max<go[i]+back[i])max= go[i]+back[i];
        }
        System.out.println(max);
    }

    static void dstra(int start,List<Node>[] graph){
        Arrays.fill(dist,INF);
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        dist[start] = 0;
        q.add(new int[]{start,0});
        while(!q.isEmpty()){
            int[] now  = q.poll();
            int cur = now[0];
            int cost = now[1];
            if(cost>dist[cur])continue;
            for(Node node:graph[cur]){
                if(node.w+cost<dist[node.to]){
                    dist[node.to] = node.w+cost;
                    q.add(new int[]{node.to,dist[node.to]});
                }
            }
        }
    }

}
