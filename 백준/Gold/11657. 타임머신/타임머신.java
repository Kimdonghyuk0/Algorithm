import java.io.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] from,to,cost;
        from = new int[M];
        to = new int[M];
        cost = new int[M];
        long[] dist = new long[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from[i] = Integer.parseInt(st.nextToken());
            to[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j<N-1; j++) {
            for (int i = 0; i < M; i++) {
                int now = from[i];
                int next = to[i];
                if (dist[now]!=Integer.MAX_VALUE&&dist[next] > dist[now] + cost[i]) {
                    dist[next] = dist[now] + cost[i];
                }
            }
        }
        //사이클
        for (int i = 0; i < M; i++) {
            int now = from[i];
            int next = to[i];
            if (dist[now]!=Integer.MAX_VALUE&&dist[next] > dist[now] + cost[i]) {
                System.out.print(-1);
                return;
            }
        }
        for(int i = 2; i<=N; i++){
            if(dist[i]==Integer.MAX_VALUE)System.out.println(-1);
            else System.out.println(dist[i]);
        }



    }

}
