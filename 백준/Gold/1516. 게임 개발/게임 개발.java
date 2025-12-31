import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        int[] indegree = new int[N+1];
        int[] timeArr = new int[N+1];
        int[] result = new int[N+1];

        for(int i = 0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        // 위상정렬 초기 세팅
        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            timeArr[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int pre = Integer.parseInt(st.nextToken());
                if(pre == -1)break;
                graph[pre].add(i);
                indegree[i]++;
            }

        }
        // 큐에 넣을 때는 시간 덜 걸리는애 먼저 넣기
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i<N+1; i++){
            if(indegree[i]==0){
                q.add(i);
                result[i]=timeArr[i];
            }
        }


        while(!q.isEmpty()){

            int building = q.poll();

            for(int next:graph[building]){
                indegree[next]--;
                result[next] = Math.max(result[next], result[building] + timeArr[next]);
                if(indegree[next]!=0)continue;
                q.add(next);
                
            }

        }
        for(int i = 1; i<N+1; i++)System.out.println(result[i]);

    }

}
