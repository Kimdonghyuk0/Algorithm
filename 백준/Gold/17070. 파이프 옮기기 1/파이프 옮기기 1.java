import java.io.*;
import java.util.*;


public class Main {
    public static int N;
    public static int[][] matrix;
    public static int ans = 0;

    static class Info{
        int y,x,state; // 기본적으로 가로 상태 1가로 2세로 3대각선
        public Info(int y, int x, int state){
            this.x = x;
            this.y = y;
            this.state = state;

        }
    }
    static void bfs(Info info){
        Queue<Info> q = new ArrayDeque<>();
        q.add(info);
        while(!q.isEmpty()){
            Info now = q.poll();
            if(now.x == N&&now.y==N){
                ans++;
                continue;
            }
            final int y = now.y, x = now.x, s = now.state;
            final int x1 = x + 1, y1 = y + 1;

            final boolean rOK  = (x1 <= N) && (matrix[y][x1] != 1);    // 오른쪽
            final boolean dOK  = (y1 <= N) && (matrix[y1][x] != 1);    // 아래
            final boolean rdOK = rOK && dOK && (matrix[y1][x1] != 1);  // 대각(3칸 모두 비어야)

            switch (s) {
                case 1: // 가로
                    if (rOK)  q.add(new Info(y,  x1, 1));
                    if (rdOK) q.add(new Info(y1, x1, 3));
                    break;

                case 2: // 세로
                    if (dOK)  q.add(new Info(y1, x,  2));
                    if (rdOK) q.add(new Info(y1, x1, 3));
                    break;

                case 3: // 대각
                    if (rOK)  q.add(new Info(y,  x1, 1));
                    if (dOK)  q.add(new Info(y1, x,  2));
                    if (rdOK) q.add(new Info(y1, x1, 3));
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N =  Integer.parseInt(br.readLine());
        //1,1부터 시작
        //좌표 할당
        matrix = new int[N+1][N+1];
        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(new Info(1,2,1)); // 파이프 끝을 기준으로 탐색 시작 상태는 1
        System.out.println(ans);

    }
}