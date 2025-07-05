import java.io.*;
import java.util.*;



public class Main {
static int nV,nE,start;
static boolean[] visited;
static int[] dist;
static ArrayList<Node>[] graph;

static class Node{
    int v;
    int cost;
    public Node(int v, int cost){
        this.v = v;
        this.cost = cost;
    }

}


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nV = Integer.parseInt(st.nextToken());
        nE = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        visited = new boolean[nV+1];
        dist = new int[nV+1];
        graph = new ArrayList[nV+1];
        int v,e,w;
        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i = 0; i<nE; i++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[v].add(new Node(e,w));
        }
        dijkstra(start);
        for(int i = 1; i<dist.length; i++){
            if(dist[i]==Integer.MAX_VALUE)System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
        q.add(new Node(start,0));
        dist[start] = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(visited[now.v])continue;
            visited[now.v] = true;
            for(Node next: graph[now.v]){
                if(!visited[next.v]&&dist[next.v]>now.cost+next.cost){
                    dist[next.v] = now.cost+next.cost;
                    q.add(new Node(next.v,dist[next.v]));
                }
            }
        }
    }
}