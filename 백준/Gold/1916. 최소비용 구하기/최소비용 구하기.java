import java.io.*;
import java.util.*;



public class Main {
    static int N,M;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Node>[] graph;
    static class Node{
        int V;
        int W; //가중치
        public Node(int V,int W){
            this.V = V;
            this.W = W;

        }
    }
    static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.W-b.W);
        q.add(new Node(start,0));

        dist[start] = 0;
        while(!q.isEmpty()){
            Node temp = q.poll();
            if (visited[temp.V]) continue;
            visited[temp.V] = true;
            for(Node node : graph[temp.V]){
                if(!visited[node.V]&&temp.W+node.W < dist[node.V]){
                    dist[node.V] =temp.W+node.W;
                    q.add(new Node(node.V,dist[node.V]));

                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

         N = Integer.parseInt(br.readLine());
         M = Integer.parseInt(br.readLine());
         visited = new boolean[N+1];
         dist = new int[N+1];
         graph = new ArrayList[N+1];
         for(int i = 0; i<graph.length; i++){
             graph[i] = new ArrayList<>();
         }
         for(int i = 0; i<dist.length; i++){
             dist[i] = Integer.MAX_VALUE;
         }
         int v,e,w;
         for(int i = 0; i<M; i++){
             st = new StringTokenizer(br.readLine());
             v = Integer.parseInt(st.nextToken());
             e = Integer.parseInt(st.nextToken());
             w = Integer.parseInt(st.nextToken());
             graph[v].add(new Node(e,w));
         }
         st = new StringTokenizer(br.readLine());
         int start,target;
         start = Integer.parseInt(st.nextToken());
         target = Integer.parseInt(st.nextToken());
         dijkstra(start);
         System.out.println(dist[target]);
    }
}