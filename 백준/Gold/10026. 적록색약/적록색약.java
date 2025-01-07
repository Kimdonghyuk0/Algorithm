import java.io.*;
import java.util.*;


public class Main {
    public static char[][] arr = new char[101][101]; //정상용
    public static char[][] arr2 = new char[101][101]; //색맹용

    public static int bfs(int y, int x, int N) {
        int ans = 0;
        boolean[][] visited = new boolean[101][101];
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        char color;
        while (true) {
            boolean flag = false;
            q.add(new int[]{y, x});
            visited[y][x] = true;
            color = arr[y][x];
            while (!q.isEmpty()) {
                int x1, y1, x2, y2;
                int[] temp;
                temp = q.poll();
                x1 = temp[1];
                y1 = temp[0];
                for (int i = 0; i < 4; i++) {
                    y2 = y1 + dy[i];
                    x2 = x1 + dx[i];
                    if (y2 < 0 || x2 < 0 || y2 >= N || x2 >= N || visited[y2][x2]) continue;
                    if (color == arr[y2][x2]) {
                        q.add(new int[]{y2, x2});
                        visited[y2][x2] = true;
                    }
                }

            }
            ans++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        flag = true;
                        y = i;
                        x = j;
                    }
                }
            }
            if (!flag) break;
        }

        return ans;
    }

    public static int bfs2(int y, int x, int N) { //색맹용
        int ans = 0;
        boolean[][] visited = new boolean[101][101];
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        char color;
        while (true) {
            boolean flag = false;
            q.add(new int[]{y, x});
            visited[y][x] = true;
            color = arr2[y][x];
            while (!q.isEmpty()) {
                int x1, y1, x2, y2;
                int[] temp;
                temp = q.poll();
                x1 = temp[1];
                y1 = temp[0];
                for (int i = 0; i < 4; i++) {
                    y2 = y1 + dy[i];
                    x2 = x1 + dx[i];
                    if (y2 < 0 || x2 < 0 || y2 >= N || x2 >= N || visited[y2][x2]) continue;
                    if (color == arr2[y2][x2]) {
                        q.add(new int[]{y2, x2});
                        visited[y2][x2] = true;
                    }
                }

            }
            ans++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        flag = true;
                        y = i;
                        x = j;
                    }
                }
            }
            if (!flag) break;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                arr[i][j] = c;
                if (c == 'G') arr2[i][j] = 'R';
                else arr2[i][j] = c;
            }
        }
        int ans = bfs(0, 0, N);
        System.out.print(ans+" ");

        ans = bfs2(0, 0, N);
        System.out.println(ans);


    }


}
