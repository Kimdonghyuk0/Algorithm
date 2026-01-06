import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            String[] s = br.readLine().split(" ");
            int[] input = new int[s.length];

            for (int ii = 1; ii < s.length; ii++) {
                input[ii] = Integer.parseInt(s[ii]);
            }
            for (int k = 1; k < s.length-1; k++) {
                graph[input[k]].add(input[k+1]);
                indegree[input[k+1]]+=1;
            }
        }
        int count = 0; // 큐에 들어간 노드 개수
        // 큐에 진입차수 0인 애 추가
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i<N+1; i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int singer = q.poll();
            sb.append(singer).append("\n");
            for(int next: graph[singer]){
                indegree[next]--;
                if(indegree[next]==0){
                    count++;
                    q.add(next);
                }
            }
        }
        if(count<N)System.out.print("0");
        else System.out.println(sb);

    }

}
