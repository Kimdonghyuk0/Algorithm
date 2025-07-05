import java.io.*;
import java.util.*;



public class Main {
static int nV,nE;
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

        dist = new int[nV+1];
        graph = new ArrayList[nV+1];
        int v,e,w;
        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<nE; i++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[v].add(new Node(e,w));//양방향 간선
            graph[e].add(new Node(v,w));
        }
        int v1,v2; // 반드시 지나야 됨
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long case1 = 0;
        long case2 = 0;

        //1->v1->v2->nV
        case1+=dijkstra(1,v1);
        case1+=dijkstra(v1,v2);
        case1+=dijkstra(v2,nV);

        //1->v2->v1->nv
        case2+=dijkstra(1,v2);
        case2+=dijkstra(v2,v1);
        case2+=dijkstra(v1,nV);
        long ans = (case1>=Integer.MAX_VALUE&&case2>=Integer.MAX_VALUE)?-1:Math.min(case1,case2);
        System.out.println(ans);


    }

    private static int dijkstra(int start,int end) {
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
        q.add(new Node(start,0));
        dist[start] = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(Node next: graph[now.v]){
                if(dist[next.v]>now.cost+next.cost){
                    dist[next.v] = now.cost+next.cost;
                    q.add(new Node(next.v,dist[next.v]));
                }
            }
        }
        return dist[end];
    }
}