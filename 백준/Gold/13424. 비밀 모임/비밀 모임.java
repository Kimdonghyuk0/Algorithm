import java.io.*;
import java.util.*;


// 정점 N개 간선 M개 친구는 K명
// N*(N*logM)
// 각 정점을 순회하면서 다익스트라로 친구 거리까지 최종거리 구하고 min갱신 하면 답
class Node{
    int to,cost;
    Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}
public class Main {
    static int N,M;
    static int[] dist;
    static List<Node>[] graph;
    static int[] friends;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            ans = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            dist = new int[N+1];
            //그래프 초기화
            graph = new ArrayList[N+1];
            for(int i = 0; i<N+1; i++){
                graph[i] = new ArrayList<>();
            }
            for(int i = 0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int from,to,cost;
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                cost = Integer.parseInt(st.nextToken());
                graph[from].add(new Node(to,cost));
                graph[to].add(new Node(from,cost));
            }
            int k = Integer.parseInt(br.readLine());
            friends = new int[k];// 친구의 수

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<k; i++){
                friends[i] = Integer.parseInt(st.nextToken());
            }
            // 모든 방을 돌면서 다익스트라
            int max =  Integer.MAX_VALUE;
            for(int i = 1; i<=N; i++ ){
                Arrays.fill(dist,Integer.MAX_VALUE);
                int v = dstra(i);
                if(v<max){
                    max = v;
                    ans = i;
                }
            }
            System.out.println(ans);

        }


    }

    private static int dstra(int start) { // start에서 모든 정점의 최소거리를 구해라
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{ //to,cost 여기서 cost는 누적 비용
            return a[1]-b[1];
        });
        dist[start] = 0;
        q.add(new int[]{start,0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            int to = now[0];
            int cost = now[1];
            if(dist[to]<cost)continue;
            for(Node node:graph[to]){
                if(dist[to]!=Integer.MAX_VALUE&&dist[node.to]>dist[to]+node.cost){
                    dist[node.to] = dist[to]+node.cost;
                    q.add(new int[]{node.to,dist[node.to]});
                }
            }
        }
        int sum = 0;
        for(int f:friends){
            sum+=dist[f];
        }
        return sum;
    }

}
