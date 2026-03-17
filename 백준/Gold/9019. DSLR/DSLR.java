import java.io.*;
import java.util.*;


public class Main {
    static String bfs(int start, int target) {
        boolean[] visited = new boolean[10000];
        Queue<Integer> q = new ArrayDeque<>();
        int[] parent = new int[10000];
        char[] cmd = new char[10000];
        q.add(start);
        visited[start] = true;
        parent[start] = -1;
        while (!q.isEmpty()) {
            int now = q.poll();
            int a, b, c, d;
            a = now / 1000;
            b = (now / 100) % 10;
            c = (now / 10) % 10;
            d = now % 10;

            int[] nexts = {commandD(now), commandS(now), commandL(a,b,c,d), commandR(a,b,c,d)};
            char[] cmds = {'D', 'S', 'L', 'R'};

            for (int i = 0; i < 4; i++) {
                int nextNum = nexts[i];
                if (!visited[nextNum]) {
                    q.add(nexts[i]);
                    visited[nextNum] = true;
                    parent[nextNum] = now;
                    cmd[nextNum] = cmds[i];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int cur = target;
        while (cur != start) {
            sb.append(cmd[cur]);
            cur = parent[cur];
        }
        return sb.reverse().toString();
    }

    static int commandD(int now){
        return (now * 2) % 10000;
    }

    static int commandS(int now){
        return now == 0 ? 9999 : now - 1;
    }

    static int commandL(int a, int b, int c, int d){
        return b * 1000 + c * 100 + d * 10 + a;
    }

    static int commandR(int a, int b, int c, int d){
        return commandL(c, d, a, b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //0이상 10000미만
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            System.out.println(bfs(start, target));
        }
    }
}