import java.io.*;
import java.util.*;

class Node{
    int to;
    int w;

    Node(int to, int w){
        this.to = to;
        this.w = w;
    }
}
public class Main {
    static int n, m, r;// 지역 갯수 , 수색범위 간선 갯수
    static int[] items;
    static ArrayList<Node>[] graph;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for(int i = 0; i<n+1; i++)graph[i] = new ArrayList<>();
        items = new int[n+1];

        // 아이템 개수 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e,w));
            graph[e].add(new Node(s,w));
        }
        int ans = 0;
        for(int i = 1; i<=n; i++){
            int[] dist = dijkstra(i);
            int sum = 0;
            for(int j = 1; j<=n; j++){
                if(dist[j]<=m)sum+=items[j];
            }
            ans = Math.max(ans,sum);
        }
        System.out.print(ans);
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        pq.offer(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[1]>dist[cur[0]])continue;
            for(Node next:graph[cur[0]]){
                if(dist[next.to]>dist[cur[0]]+next.w){
                    dist[next.to] = dist[cur[0]]+next.w;
                    pq.offer(new int[]{next.to, dist[next.to]});
                }
            }
        }

        return dist;

    }
}