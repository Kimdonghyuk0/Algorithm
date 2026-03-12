import java.io.*;
import java.util.*;

public class Main {
    static int[][] val;
    static boolean[][] visited;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static int N,M;
    static int ans = 0;

    static void dfs(int y, int x, int depth, int sum){
        if(depth == 4){
            ans = Math.max(ans, sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny<0||nx<0||ny>=N||nx>=M) continue;
            if(visited[ny][nx]) continue;
            visited[ny][nx] = true;
            dfs(ny, nx, depth+1, sum+val[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    static void checkT(int y, int x) {
        int sum = val[y][x];
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            cnt++;
            sum += val[ny][nx];
            min = Math.min(min, val[ny][nx]);
        }
        // cnt==4: 4방향 다 있으면 최솟값 하나 제거
        if (cnt == 4) ans = Math.max(ans, sum - min);
        // cnt==3: 3방향이면 그대로 사용
        if (cnt == 3) ans = Math.max(ans, sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        val = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                val[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                visited[i][j] = true;
                dfs(i, j, 1, val[i][j]);
                visited[i][j] = false;
                checkT(i, j);
            }
        }

        System.out.println(ans);
    }
}