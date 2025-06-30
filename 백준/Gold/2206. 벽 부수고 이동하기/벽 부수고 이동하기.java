import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int [][] matrix;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M;
    static class Point{
        int y;
        int x;
        int dist;
        boolean isBreak;
        Point(int y,int x, int dist, boolean isBreak){
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.isBreak = isBreak;
        }
    }
    static int bfs(){
        boolean[][] isVisited = new boolean[N][M];
        boolean[][] isBreakVisited = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1,false));
        isVisited[0][0] = true;
        while(!q.isEmpty()){
            Point temp = q.poll();
            if(temp.y == N-1&&temp.x==M-1)return temp.dist;

            for(int i = 0; i<4; i++){
                int ty = temp.y+dy[i];
                int tx = temp.x+dx[i];
               if(tx>-1&&ty>-1&&tx<M&&ty<N) {
                   if (!temp.isBreak) {
                       if (matrix[ty][tx] == 0 && !isVisited[ty][tx]) {
                           q.add(new Point(ty, tx, temp.dist + 1, temp.isBreak));
                           isVisited[ty][tx] = true;
                       } else if (matrix[ty][tx] == 1 && !isBreakVisited[ty][tx]) {
                           q.add(new Point(ty, tx, temp.dist + 1, true));
                           isBreakVisited[ty][tx] = true;
                       }
                   }
                   else{
                        if(matrix[ty][tx] == 0 && !isBreakVisited[ty][tx]){
                           q.add(new Point(ty, tx, temp.dist + 1, true));
                           isBreakVisited[ty][tx] = true;
                       }
                   }
               }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        matrix = new int[N][M];
        for(int i = 0; i<N; i++){
            input = br.readLine().split("");
            for(int k = 0; k<M; k++){
                matrix[i][k] = Integer.parseInt(input[k]);
            }
        }
        int ans = bfs();
        System.out.println(ans);
    }



}
