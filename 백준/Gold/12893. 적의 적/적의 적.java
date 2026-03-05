import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] color = new int[2001];//0은 미방문 -1팀1팀
    static boolean bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        color[start] = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            int nowColor = color[now];
            for(int next:graph[now]){
                if(color[now]==color[next])return false;
                if(color[next]==0){
                    color[next] = nowColor*-1;
                    q.add(next);
                }

            }

        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 같은 적을 가지고 있으면 친구고, 같은 친구를 가지고 있으면 적이다. 한다리 건너야 친구임
        // 새로운 연결을 추가할때 해당 정점까지 거리가 짝수인 길이 존재하면 안된다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        for(int i = 1; i<=N; i++){
            if(color[i]==0&&!bfs(i)){
                System.out.println(0);
                return;
            };
        }
        System.out.println(1);
    }
}