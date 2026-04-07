import java.io.*;
import java.util.*;


class Node{
    int to, w;
     Node(int to,int w){
        this.to = to;
        this. w = w;
    }
}
public class Main {
    static int n,m;
    static List<Node>[] graph;
    static int[] dist;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        graph = new List[n+1];
        for(int i = 0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s,e,c;
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e,c));
            graph[e].add(new Node(s,c));
        }
        int start,end;
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        Arrays.fill(dist,Integer.MAX_VALUE);
        dijkstra(start);

        System.out.println(dist[end]);


    }

    private static void dijkstra(int start) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        dist[start] = 0;
        q.add(new int[]{start,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int now = cur[0];
            int cost = cur[1];
            if(dist[now]<cost)continue;
            for(Node node:graph[now]){
                if(dist[node.to]>node.w+dist[now]){
                    q.add(new int[]{node.to,node.w+dist[now]});
                    dist[node.to] = node.w+dist[now];
                }
            }
        }
    }
}