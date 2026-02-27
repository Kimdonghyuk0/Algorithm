import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    static boolean[][] visited;
    static int[][] height;
    static int N;
    static int max = 1;
    private static void bfs(int rain, int startY, int startX) {
        Queue<int[]> q = new ArrayDeque<>();
        // 미방문, 물에 안잠기는 애들만 방문하기
        q.add(new int[]{startY,startX});
        visited[startY][startX]  = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];
            for(int i = 0; i<4; i++){
                int nextY = nowY+dy[i];
                int nextX = nowX+dx[i];
                if(nextX<0||nextY<0||nextX>N-1||nextY>N-1||height[nextY][nextX]<=rain||visited[nextY][nextX])continue;
                q.add(new int[]{nextY,nextX});
                visited[nextY][nextX] = true;
            }



        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //모든 수에 대해서 bfs탐색을 해서 안전 영역 카운트를 한다.
        //worst: 100*100*100인데 모든 좌표에서 또 돌아야하니 100을 더 곱하면 100000000 1초임
        // 그리디로 불가능, 이분탐색도 불가능
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        height = new int[N][N];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k = 0; k<N; k++){
                height[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        // 잠기는 높이별로 전부 해보기 비는 0-99까지 내리고 크면 생존임 작거나 같으면 잠기는거
        for(int i = 0; i<=99; i++){
            // 항상 초기화 하기
            int count = 0;
            for (int j = 0; j < N; j++) {
                Arrays.fill(visited[j], false);
            }
            for(int k = 0; k<N; k++){
                for(int j = 0; j<N; j++){
                    // 방문했거나 물에 잠기면 패스
                    if(visited[k][j]||i>=height[k][j])continue;
                    count++;
                    bfs(i,k,j);

                }
            }
            // 크면 갱신
            max = Math.max(count,max);

        }

        System.out.println(max);
    }


}
