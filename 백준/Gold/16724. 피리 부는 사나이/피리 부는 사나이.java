import java.io.*;
import java.util.*;

class Main {
    static String[][] graph;
    static int[][] visit;
    static int count = 0;
    static void dfs(int y, int x){
        visit[y][x] = 1;
        String now = graph[y][x];
        int nextY = -1;
        int nextX = -1;
        if(now.equals("D")){
            nextY = y+1;
            nextX = x;
        }
        else if(now.equals("U")){
            nextY = y-1;
            nextX = x;
        }
        else if(now.equals("L")){
            nextY = y;
            nextX = x-1;

        }else if(now.equals("R")){
            nextY = y;
            nextX = x+1;
        }
        if(visit[nextY][nextX]==0)dfs(nextY,nextX);
        else if (visit[nextY][nextX]==1)count++;
        visit[y][x] = 2;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //그래프 문제임 총 몇개의 연결된 그래프가 존재하는지 새면 됨

        int N,M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new String[N][M];
        visit = new int[N][M];
        for(int i = 0; i<N; i++){
            String[] input = br.readLine().split("");
            for(int k = 0; k<input.length; k++){
                graph[i][k] = input[k];
            }
        }
        for(int i = 0; i<N; i++){
            for(int k = 0; k<M; k++){
                if(visit[i][k]==0)dfs(i,k);
            }
        }
        System.out.println(count);
    }
}