import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] houses;
    static boolean[][] visited;
    static ArrayList<Integer> count = new ArrayList<>();
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static int N;
    static int bfs(int y,int x){
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y,x});
        count++;
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];
            for(int i = 0; i<4; i++){
                int nextY = nowY+dy[i];
                int nextX = nowX+dx[i];
                if(nextX<0||nextY<0||nextX>N-1||nextY>N-1||houses[nextY][nextX]==0)continue;
                if(!visited[nextY][nextX]){
                    count++;
                    visited[nextY][nextX] = true;
                    q.add(new int[]{nextY,nextX});
                }
            }
        }


        return count;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        houses = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i<N; i++){
            String[] input = br.readLine().split("");
            for(int k = 0; k<N; k++){
                houses[i][k] = Integer.parseInt(input[k]);
            }
        }
        // 격자를 돌다가 방문처리 안된 집을 만나면 bfs 탐색하고 연결된 단지를 리스트에 추가하기
        for(int i = 0; i<N; i++){
            for(int k = 0; k<N; k++){
                if(houses[i][k]==1&&!visited[i][k]){
                    count.add(bfs(i,k));
                }
            }
        }
        Collections.sort(count);

        System.out.println(count.size());
        for(int n:count)System.out.println(n);

    }
}
