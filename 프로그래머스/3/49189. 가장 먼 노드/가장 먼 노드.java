import java.util.*;

class Solution {
    int[]dist; //-1이면 미방문
    List<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 거리 배열 초기화
        dist = new int[n+1];
        for(int i = 0; i<n+1; i++){
            dist[i] = -1;
        }
        //그래프 초기화
        graph = new List[n+1];
        for(int i = 0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        // 그래프 연결 정보 추가
        for(int arr[]: edge){
            graph[arr[0]].add(arr[1]);
            graph[arr[1]].add(arr[0]);
        }
        //bfs 탐색으로 dist 배열에 값 추가
        bfs(1);
        int max = 0;
        for(int temp:dist)if(temp>max)max = temp;
        for(int temp:dist)if(temp==max)answer++;
        System.out.print(max);
        return answer;
    }
    void bfs(int start){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1,0});
        dist[1] = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            
                for(int next:graph[now[0]]){
                    if(dist[next] == -1){
                        q.add(new int[]{next,now[1]+1});
                        dist[next] = now[1]+1;
                    }
                }
            
        }
    }
    
}


//dist배열에 거리 추가하고 가장 큰 값과 같은 개수가 몇개인지 answer