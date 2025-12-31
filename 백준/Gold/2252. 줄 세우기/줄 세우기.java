import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N,M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        int[] indegree = new int[N+1];

        for(int i = 0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s,e;
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            indegree[e]++;
        }
        //큐에 indegree가 0인 노드를 먼저 추가
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<indegree.length;i++){
            if(indegree[i]==0)q.add(i);
        }
        while(!q.isEmpty()){
            int student = q.poll();
            sb.append(student).append(" ");
            //q가 가리키는 노드의 indegree를 --
            for(int next:graph[student]){
                indegree[next]--;
                if(indegree[next]==0)q.add(next);
            }

        }
        System.out.println(sb);

    }

}
