import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int [][] matrix;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M,K;
    static class Point{
        int y;
        int x;
        int dist;
        int countBreak;
        boolean isDay; // true면 벽부수기 가능
        Point(int y,int x, int dist, int countBreak, boolean isDay){
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.countBreak = countBreak;
            this.isDay = isDay;
        }
    }
    static int bfs(){
      int[][][][] visited = new int[2][K+1][N][M];
      //int[][] breakWall = new int[N][M];
      Queue<Point> q = new LinkedList<>();
      q.add(new Point(0,0,1,0,true) );
      visited[0][0][0][0] = 1;
      while(!q.isEmpty()){
          Point temp = q.poll();
          if(temp.y == N-1&& temp.x ==M-1)return temp.dist;
          for(int i = 0; i<4; i++){
              int ty = temp.y + dy[i];
              int tx = temp.x + dx[i];
              if(ty<0||tx<0||ty>N-1||tx>M-1)continue;
              if(matrix[ty][tx]==0) { // 벽안뚫 경우
                  if(temp.isDay) {
                      if (visited[0][temp.countBreak][ty][tx] ==
                      0 || visited[0][temp.countBreak][ty][tx] > temp.dist + 1 )
                      {
                          q.add(new Point(ty, tx, temp.dist + 1, temp.countBreak, !temp.isDay));
                          visited[0][temp.countBreak][ty][tx] = temp.dist + 1;
                      }
                  }
                  else{
                      if (visited[1][temp.countBreak][ty][tx] ==
                              0 || visited[1][temp.countBreak][ty][tx] > temp.dist + 1 )
                      {
                          q.add(new Point(ty, tx, temp.dist + 1, temp.countBreak, !temp.isDay));
                          visited[1][temp.countBreak][ty][tx] = temp.dist + 1;
                      }
                  }
              }
              else{ //벽뚫 경우
                  if(temp.countBreak<K){
                      if(temp.isDay&&(visited[0][temp.countBreak+1][ty][tx]==0||visited[0][temp.countBreak+1][ty][tx] > temp.dist + 1 )){//바로 뚫기 가능
                          q.add(new Point(ty,tx,temp.dist+1, temp.countBreak+1,!temp.isDay ));
                          visited[0][temp.countBreak+1][ty][tx] = temp.dist +1;

                      }
                      else if(!temp.isDay&&(visited[1][temp.countBreak][temp.y][temp.x]==0||visited[1][temp.countBreak][temp.y][temp.x] > temp.dist + 1 )){ //기다려야됨 가만히 있는경우
                          q.add(new Point(temp.y, temp.x, temp.dist+1, temp.countBreak,!temp.isDay ));
                          visited[1][temp.countBreak][temp.y][temp.x] = temp.dist +1;

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
        K = Integer.parseInt(input[2]);
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
