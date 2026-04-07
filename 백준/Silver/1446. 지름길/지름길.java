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
    static List<Node>[] graph;
    static int[] dist;
    static int D;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dist = new int[D+1];
        graph = new List[D+1];
        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(start>D)continue;
            graph[start].add(new Node(end,w));
        }
        for (int i = 0; i < D; i++) {
            graph[i].add(new Node(i + 1, 1));
        }
        dstra();

        System.out.println(dist[D]);
    }

    private static void dstra() {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            int cur = now[0];
            int cost = now[1];
            if(cost>dist[cur])continue;
            for(Node next:graph[cur]){
                if(next.to>D)continue;
                if(dist[next.to]>next.w+cost){
                    q.add(new int[]{next.to,cost+next.w});
                    dist[next.to] = next.w+cost;
                }
            }
        }


    }
}