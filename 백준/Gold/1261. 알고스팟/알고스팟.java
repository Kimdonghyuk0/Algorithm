import java.io.*;
import java.util.*;


class Node{
    int x,y,cost;
    public Node(int y, int x, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
public class Main {
    static int n,m;
    static int[][] map;
    static int[][] dist;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        dist = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        //1,1->n,m 가는데 최소비용
        for(int i = 1; i<=n; i++){
            String[] input = br.readLine().split("");
            for(int j = 1; j<=m; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }
        dijkstra();
        System.out.println(dist[n][m]);

    }

    private static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        dist[1][1] = 0;
        pq.add(new Node(1,1,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.cost>dist[now.y][now.x])continue;
            for(int i = 0; i<4; i++){
                if(now.y+dy[i]<1||now.y+dy[i]>n||now.x+dx[i]<1||now.x+dx[i]>m)continue;
                int nextW = map[now.y+dy[i]][now.x+dx[i]];
                if((nextW+now.cost)<dist[now.y+dy[i]][now.x+dx[i]]){
                    dist[now.y+dy[i]][now.x+dx[i]] = nextW+now.cost;
                    pq.add(new Node(now.y+dy[i],now.x+dx[i],nextW+now.cost));
                }
            }
        }


    }
}