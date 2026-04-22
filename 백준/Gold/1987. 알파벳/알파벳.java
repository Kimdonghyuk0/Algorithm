import java.io.*;
import java.util.*;

// 세트를 사용한 DFS로 풀면 편하겠다.

public class Main {
    static int R,C;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static String[][] board;
    static boolean[][] visited;
    static int ans = 1;

    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new String[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i<R; i++){
            String[] input = br.readLine().split("");
            board[i] = input;
        }
        dfs(0,0,1);
        System.out.println(ans);
    }
    static void dfs(int y, int x,int count){
        int before = set.size();
        set.add(board[y][x]);
        int after = set.size();
        if(before==after)return;
        if(count>ans)ans = count;
        for(int i = 0; i<4; i++){
            int nextY = y+dy[i];
            int nextX = x+dx[i];
            if(nextX<0||nextY<0||nextY>=R||nextX>=C||visited[nextY][nextX])continue;
            visited[nextY][nextX] = true;
            dfs(nextY,nextX,count+1);
            visited[nextY][nextX] = false;
        }
        set.remove(board[y][x]);

    }

}
