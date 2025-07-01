import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static Point[][] matrix;
    static int N, M;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,1,-1};

    static class Point {
        int y;
        int x;
        boolean isOn;
        int[] button;
        Queue<int[]> buttons = new LinkedList<>();
        Point(int y, int x,boolean isOn,int[] button){
            this.y = y;
            this.x = x;
            this.isOn = isOn;
            this.button = button;
            if(button.length!=0)buttons.add(button);
        }
    }

    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(matrix[0][0]);
        visited[0][0] = true;
        while(!q.isEmpty()){
            Point temp = q.poll();
            //스위치 다 켜기
            boolean flag = false;
            while(!temp.buttons.isEmpty()){
                int[] btn = temp.buttons.poll();
                int ty = btn[0];
                int tx = btn[1];
                matrix[ty][tx].isOn = true;
                flag =true;
            }
            if(flag){ //스위치가 켜지면 방문 초기화
                for(int i = 0; i<N; i++){
                    for(int j = 0; j<N; j++){
                        visited[i][j] = false;
                    }
                }
            }
            for(int i = 0; i<4; i++){
                int ty = temp.y+dy[i];
                int tx = temp.x+dx[i];
                if(ty<0||tx<0||ty>N-1||tx>N-1||!matrix[ty][tx].isOn||visited[ty][tx])continue;
                q.add(matrix[ty][tx]);
                visited[ty][tx] = true;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new Point[N][N];
        visited = new boolean[N][N];
        int[] empty = new int[0];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                matrix[i][j] = new Point(i,j,false,empty);
            }
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int y,x,a,b;
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int[] button = new int[]{a-1,b-1};
            matrix[y-1][x-1].buttons.add(button);
        }

        matrix[0][0].isOn = true;
        bfs();
        int ans = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(matrix[i][j].isOn)ans++;
            }
        }
        System.out.println(ans);

    }
}