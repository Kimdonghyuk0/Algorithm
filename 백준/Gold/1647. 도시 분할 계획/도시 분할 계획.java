import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int total = 0;
    static int[] parent;

    static class Node implements Comparable<Node>{
        int to;
        int from;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static boolean union(int x, int y){
        int xp = find(x);
        int yp = find(y);
        if(xp==yp)return false;
        if(xp<=yp)parent[yp] = xp;
        else parent[xp] = yp;
        return true;
    }
    static int find(int x){
        int xp = parent[x];
        if(x==xp)return x;
        return find(xp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        int N,M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 부모 배열 초기화
        parent = new int[N+1];
        for(int i = 0; i<N+1; i++){
            parent[i] = i;
        }
        // 양방향임
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node(from, to, cost));
        }
        Collections.sort(list); //cost기준으로 오름차순 정렬
        int lastValue = 0; // 마지막에 추가된 간선의 가중치는 빼야 마을이 분리됨
        int sum = 0;
        for(Node node:list){
            // 만약 사이클이 없다면 추가
            if(union(node.from,node.to)){
                lastValue = node.cost;
                sum+=lastValue;
            }
        }
        System.out.println(sum-lastValue);
    }
}
