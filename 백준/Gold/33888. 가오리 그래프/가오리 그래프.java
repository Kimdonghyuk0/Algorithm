
import java.io.*;
import java.util.*;



public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] abcdef = new int[6];
    static boolean[] visited;
    static int dfs_4(int now) {
        visited[now] = true;

        // E 찾기 (간선 4개인 노드)
        if (graph[now].size() == 4) return now;


        for (int next : graph[now]) {
            if (!visited[next]) {
                int found = dfs_4(next);
                if (found != -1) return found;
            }
        }
        return -1;
    }

    static void dfs_3(int now) {

        if(!visited[now]&&graph[now].size()==4){
            abcdef[2] = now;
            return ;
        }
        visited[now] = true;
        // E 찾기 (간선 3개인 노드)
        if (graph[now].size() == 3) {
            if(abcdef[1]==0) abcdef[1] = now;
            else if(abcdef[0]==0)abcdef[0] = now;
            else if(abcdef[3]==0)abcdef[3] = now;

        }


        for (int next : graph[now]) {
            if (!visited[next]) {
                dfs_3(next);
            }
        }
        return ;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i =0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        int U,V;
        for(int i = 0; i<N+3; i++){
            st = new StringTokenizer(br.readLine());
            U = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            graph[U].add(V);
            graph[V].add(U);
        }
        // 간선이 1개,4개인 노드를 찾는다.
        for(int i = 0; i<graph.length; i++){
            if(graph[i].size()==1){
                abcdef[4] = dfs_4(i);
                abcdef[5] = i;
            }
        }
        dfs_3(abcdef[4]);



        if(abcdef[1]>abcdef[3]){ //D>B조건 만족
            int temp = abcdef[3];
            abcdef[3] = abcdef[1];
            abcdef[1] = temp;
        }
        for(int k:abcdef)System.out.print(k+" ");


    }
}