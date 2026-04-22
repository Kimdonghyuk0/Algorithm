import java.io.*;
import java.util.*;

public class Main {
    static int count;
    static int N,M;
    static String[][] board;
    static boolean[][] visited;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i<N; i++){
            board[i] = br.readLine().split("");
        }
        int max = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(board[i][j].equals("W"))continue;
                for (int r = 0; r < visited.length; r++) {
                    Arrays.fill(visited[r], false);
                }
                count = 0;
                bfs(i,j);
                max = Math.max(max,count);
            }
        }
        System.out.println(max);

    }
    static void bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y,x,0});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowCount = now[2];
            if(count<nowCount)count = nowCount;
            for(int i =0 ; i<4; i++){
                int nextY = now[0]+dy[i];
                int nextX = now[1]+dx[i];
                if(nextY<0||nextX<0||nextY>=N||nextX>=M||visited[nextY][nextX]|| board[nextY][nextX].equals("W"))continue;
                q.add(new int[]{nextY,nextX,nowCount+1});
                visited[nextY][nextX] = true;

            }
        }
    }

}
