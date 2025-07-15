import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int ans = -1; //시작 강도
    static boolean[][] visited;
    static int[][] matrix;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {1,-1,0,0};

    static boolean bfs(int start){
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        //초기 큐 세팅
        for(int i = 0; i<M; i++){
            if(start>=matrix[0][i]) {
                q.add(new int[]{0, i});
                visited[0][i] = true;
                sum++;
            }
        }
        for(int i = 1; i<N; i++){
            if(start>=matrix[i][0]) {
                q.add(new int[]{i, 0});
                visited[i][0] = true;
                sum++;
            }
        }
        for(int i = 1; i<N; i++){
            if(start>=matrix[i][M-1]) {
                q.add(new int[]{i, M-1});
                visited[i][M-1] = true;
                sum++;
            }
        }
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i<4; i++){
                int y = now[0]+dy[i];
                int x = now[1]+dx[i];
                if(y<0||x<0||y>N-1||x>M-1)continue;
                if(!visited[y][x]&&matrix[y][x]<=start){
                    q.add(new int[]{y,x});
                    visited[y][x] = true;
                    sum++;
                }
            }
        }

        //만약 sum이 K보다 크거나 같으면 true리턴
        if(sum>=K)return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1][M+1];
        matrix = new int[N+1][M+1];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean flag;
        int left = 1;
        int right = 1000000;

        while(left<=right){
            int mid = (left+right)/2;
            if(bfs(mid)){
                ans = mid;
                right = mid-1;
            }
            else left = mid+1;
            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
            }
        }
        System.out.println(ans);




    }
}