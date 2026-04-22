import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static char[][] board;
    static Set<Character> set = new HashSet<>();
    static int ans = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        
        set.add(board[0][0]);  // 시작 셀 알파벳 선추가
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    static void dfs(int y, int x, int count) {
        ans = Math.max(ans, count);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            if (set.contains(board[ny][nx])) continue;  // 이미 지난 알파벳
            
            set.add(board[ny][nx]);
            dfs(ny, nx, count + 1);
            set.remove(board[ny][nx]);
        }
    }
}