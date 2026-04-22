import java.io.*;
import java.util.*;

// 0은 검은 방, 1은 흰 방
// 전체 INF로 채우고 작을때만 가는거야 방문체크 필요없음
// 다익스트라네 ㅋㅋ
public class Main {
    static int n;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] dist;
    static int[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        board = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i<n; i++){
            String input = br.readLine();
            for(int j = 0; j<n; j++){
                board[i][j] = input.charAt(j)-'0';
            }
        }
        dstra(0,0);
        System.out.println(dist[n-1][n-1]);


    }

    static void dstra(int y, int x) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            return a[2]-b[2];
        }); //y,x,cost
        dist[y][x] = 0;
        q.add(new int[]{y,x,0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(dist[now[0]][now[1]]<now[2])continue;
            for(int i = 0; i<4; i++){
                int nextY = now[0]+dy[i];
                int nextX = now[1]+dx[i];

                if(nextX<0||nextY<0||nextX>=n||nextY>=n)continue;
                //검은 방
                if(board[nextY][nextX]==0&&dist[nextY][nextX]>now[2]+1){
                    dist[nextY][nextX] = now[2]+1;
                    q.add(new int[]{nextY,nextX,now[2]+1});
                }
                //흰방
                if(board[nextY][nextX]==1&& dist[nextY][nextX]>now[2]){
                    q.add(new int[]{nextY,nextX,now[2]});
                    dist[nextY][nextX] = now[2];
                }
            }
        }
    }

}
