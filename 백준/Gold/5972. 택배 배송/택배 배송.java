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
    static int N;
    static int M;
    static List<Node>[] graph;
    static int[] dist;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph  = new List[N+1];
        for(int i = 0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s,e,w;
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e,w));
            graph[e].add(new Node(s,w));
        }
        djk();
        System.out.println(dist[N]);
    }

    private static void djk() {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        q.add(new int[]{1,0});
        dist[1] = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int now = cur[0];
            int cost = cur[1];
            if(dist[now]<cost)continue;
            for(Node node: graph[now]){
                if(dist[node.to]<=dist[now]+node.w)continue;
                dist[node.to] = dist[now]+node.w;
                q.add(new int[]{node.to,dist[now]+node.w});
            }
        }
    }
}